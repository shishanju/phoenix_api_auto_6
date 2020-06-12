package com.lemon.futureloan.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestAPI {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
//		 * 1.打开一个发包客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
//		 * 2.输入请求地址
		String registerUrl = "http://localhost/index.php/Home/user/login.html";
//		 * 3.输入请求参数
		registerUrl += "?mobliephone=14725803692&pwd=123456&regname=happy";
//		 * 4.输入请求类型（方法：get.post）
		HttpGet get = new HttpGet(registerUrl);
//		 * 5.发包
		CloseableHttpResponse response = httpClient.execute(get);
		String result = EntityUtils.toString(response.getEntity());		
//		 * 6.判断测试用例执行结果是否符合预期
		//断言
		System.out.println(result);
		System.out.println("123");

	}

}
