package com.lemon.api.auto.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Cookie;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * @author: shishanju
 * @date: 2021/3/12
 * @protocol:
 * @apiName:
 * @description:
 */
public class apiAction<mRetrofit> {

    com.lemon.api.auto.testcase.financelog.apiServer apiServer;

    public Call<ResponseBody> ass(JSONObject request){
        Call<ResponseBody> call = apiServer.ass(request);
        return call;
    }

    public Call<ResponseBody> ali(JSONObject request){
        Call<ResponseBody> call = apiServer.ali(request);
        return call;
    }

    public Call<ResponseBody> asc(String cookie, JSONObject request){
        Call<ResponseBody> call = apiServer.asc(cookie, request);
        return call;
    }
}
