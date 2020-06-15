package com.lemon.api.auto.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil2 {

	/**
	 * post请求
	 * @param url
	 * @param parameters
	 * @return
	 */
	public static String post(String url, List<NameValuePair> parameters) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.setEntity(new UrlEncodedFormEntity(parameters));
			CloseableHttpResponse response = httpClient.execute(post);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "";
	}
	
	/**
	 * get请求方法
	 * @param url
	 * @param parameters
	 * @return
	 */
	public static String get(String url, List<NameValuePair> parameters) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			for(int i = 0; i < parameters.size(); i++) {
				StringBuilder sb = new StringBuilder(url);
				if (i == 0) {
					sb.append("?");
				}else {
					sb.append("&");
				}
				NameValuePair nameValuePair = parameters.get(i);
				String name = nameValuePair.getName();
				String value = nameValuePair.getValue();
				sb.append(name).append("=").append(value);
			}			
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = httpClient.execute(get);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "";
	}
}
