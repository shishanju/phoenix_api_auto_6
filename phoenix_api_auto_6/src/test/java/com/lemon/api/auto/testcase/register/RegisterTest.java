package com.lemon.api.auto.testcase.register;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class RegisterTest {

	@Test
	public void f() {
		String url = "http://localhost/index.php/Home/user/login.html";
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("mobliephome", "13899999999");
		parametersMap.put("pwd", "123456");
		String result = HttpUtil.post(url, parametersMap);
		System.out.println(result);
	}	
	
	public void f1() {
		//准备url
				String url = "http://localhost/index.php/Home/user/login.html";
				Map<String, String> parametersMap = new HashMap<String, String>();
				parametersMap.put("memberId", "9");
				//发包
				String result = HttpUtil.get(url, parametersMap);
				//查看结果
				System.out.println(result);
	}
}