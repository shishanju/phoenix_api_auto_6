package com.lemon.api.auto.testcase.financelog;

import com.alibaba.fastjson.JSONObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @author: shishanju
 * @date: 2021/3/12
 * @protocol:
 * @apiName:
 * @description:
 */
public interface apiServer {

    @POST("api/asd")
    Call<ResponseBody> ass(@Body JSONObject params);

    @POST("api/vfa")
    Call<ResponseBody> ali(@FieldMap Map<String, Object> params);

    @POST("api/fas")
    @FormUrlEncoded
    Call<ResponseBody> asc(@Header("cookie") String cookie, @FieldMap Map<String, Object> params );

    @GET
    Call<ResponseBody> get(@QueryMap Map<String, Object> params);
}
