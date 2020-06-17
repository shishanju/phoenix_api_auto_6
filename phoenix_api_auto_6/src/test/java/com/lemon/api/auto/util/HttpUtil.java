package com.lemon.api.auto.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	/**
	 * post请求
	 * @param url
	 * @param parameters
	 * @return
	 */
	public static String post(String url, Map<String, String> parametersMap) {
		try {
			//打开一个发包客户端
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//输入请求方法
			HttpPost post = new HttpPost(url);
			//创建一个列表
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			//把map的key放在列表
			Set<String> keySet = parametersMap.keySet();
			//循环遍历
			for (String key : keySet) {
				//把值添加到列表
				parameters.add(new BasicNameValuePair(key, parametersMap.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(parameters));
			//发包以post方式
			CloseableHttpResponse response = httpClient.execute(post);
			//通过此方法讲接口参数设置到请求体中
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
	public static String get(String url, Map<String, String> parametersMap) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet get = new HttpGet(url);
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			Set<String> keySet = parametersMap.keySet();
			for (String key : keySet) {
				parameters.add(new BasicNameValuePair(key, parametersMap.get(key)));
			}
			//格式化，使用此方法可以优化字符例如：&=等特殊字符
			String paramsPart = URLEncodedUtils.format(parameters, "Utf-8");
			url += "?" + paramsPart;	
			//发包以get方式
			CloseableHttpResponse response = httpClient.execute(get);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "";
	}
}
