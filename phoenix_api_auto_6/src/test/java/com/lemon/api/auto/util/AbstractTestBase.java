package com.lemon.api.auto.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import okhttp3.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import retrofit2.Call;
import retrofit2.Response;


/**
 * @author: shishanju
 * @date: 2021/3/16
 * @protocol:
 * @apiName:
 * @description:
 */
public class AbstractTestBase {
    private static Logger log = LoggerFactory.getLogger("AbstractTestBase");
    protected final Log logger = LogFactory.getLog(this.getClass());

    public AbstractTestBase() {
    }

    public ResultMap getResponse(Call<ResponseBody> call) throws IOException {
        log.info("@@ http请求参数：{}", call.request().toString());
        Response response = null;

        try {
            response = call.execute();
        } catch (IOException var6) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            var6.printStackTrace(pw);
            this.logger.error("\n" + sw.toString());
        }

        return this.parseResponse(response);
    }


    public ResultMap parseResponse(Response<ResponseBody> response) throws IOException {
        String url = response.raw().request().url().toString();
        ResponseBody resBody = null;
        if (response.isSuccessful()) {
            resBody = (ResponseBody)response.body();
        } else {
            resBody = response.errorBody();
        }

        String res = resBody.string();
        log.info("@@ http响应参数：{}", res);
        return new ResultMap(response.code(), res, url, response.headers());
    }
}
