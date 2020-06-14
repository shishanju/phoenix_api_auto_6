package com.lemon.api.auto.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.internal.junit.ArrayAsserts;

public class TestPost {

	public static void main(String[] args) throws ParseException, IOException {
//		 * 1.打开一个发包客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
//		 * 2.输入请求地址
		String registerUrl = "http://localhost/index.php/Home/user/login.html";
//		 * 3.输入请求类型（方法：get.post）
		HttpPost post = new HttpPost(registerUrl);
		//4.输入请求参数
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		//每一个参数对应一个对象
		parameters.add(new  BasicNameValuePair("mobliephone", "1389099000"));
		parameters.add(new BasicNameValuePair("pwd", "123456"));
		//将参数设置到请求体
		post.setEntity(new UrlEncodedFormEntity(parameters));
//		 * 5.发包
		CloseableHttpResponse response = httpClient.execute(post);
		String result = EntityUtils.toString(response.getEntity());		
//		 * 6.判断测试用例执行结果是否符合预期
		//断言
		System.out.println(result);
		System.out.println("123");
	}

}
