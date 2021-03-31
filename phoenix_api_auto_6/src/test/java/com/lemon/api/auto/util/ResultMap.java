package com.lemon.api.auto.util;

import com.alibaba.fastjson.JSON;
import okhttp3.Headers;

/**
 * @author: shishanju
 * @date: 2021/3/16
 * @protocol:
 * @apiName:
 * @description:
 */
public class ResultMap {

    private int code;
    private String data;
    private String url;
    private Headers headers;

    public ResultMap(int code, String data, String url, Headers headers) {
        this.setCode(code);
        this.setData(data);
        this.setUrl(url);
        this.setHeaders(headers);
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Headers getHeaders() {
        return this.headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
