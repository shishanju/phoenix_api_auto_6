package com.lemon.api.auto.testcase.register;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto.util.DataProviders;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @author: shishanju
 * @date: 2021/3/15
 * @protocol:
 * @apiName:
 * @description:
 */
public class TestCase {

    @Autowired
    com.lemon.api.auto.util.apiAction apiAction;

    @Test(description = "测试", dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void ali(JSONObject request) throws IOException {
        Call<ResponseBody> call = apiAction.ali(request);
        OkHttpClient  client = new OkHttpClient();
        Response response = call.execute();

    }

/*    public void get(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                ToastUtil.showToast(activity, "Get 失败");
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseStr = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showToast(activity, responseStr);
                    }
                });
            }
        });
    }*/

}
