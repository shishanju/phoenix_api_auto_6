package com.lemon.api.auto.testcase.register;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.lemon.api.auto.util.HttpUtil;
import com.lemon.api.auto.util.HttpUtil2;

public class RegisterTest2 {

	@Test
	public void f() {
//		//准备url
		String url = "http://localhost/index.php/Home/user/login.html";
//		 准备参数
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new  BasicNameValuePair("mobliephone", "1389099000"));
		parameters.add(new BasicNameValuePair("pwd", "123456"));
		//发包
		String result = HttpUtil2.post(url, parameters);
		//查看结果
		System.out.println(result);
	}	
	
	public void f1() {
		//准备url
				String url = "http://localhost/index.php/Home/user/login.html";
//				 准备参数
				List<NameValuePair> parameters = new ArrayList<NameValuePair>();
				parameters.add(new  BasicNameValuePair("moblieIg", "p"));
				//发包
				String result = HttpUtil2.get(url, parameters);
				//查看结果
				System.out.println(result);
	}
}
