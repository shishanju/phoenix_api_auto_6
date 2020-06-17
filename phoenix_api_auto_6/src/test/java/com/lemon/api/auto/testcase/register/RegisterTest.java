package com.lemon.api.auto.testcase.register;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto.CellData;
import com.lemon.api.auto.base.BastTester;
import com.lemon.api.auto.util.ApiUtil;
import com.lemon.api.auto.util.ExcelUtil;
import com.lemon.api.auto.util.HttpUtil;
import com.lemon.api.auto.util.HttpUtil2;

public class RegisterTest extends BastTester{

	@Test(dataProvider="getDatas")
	public void f(String caseId, String apiId, String requestData, String expectesReponsData) {
		//获得url
		String url = ApiUtil.getUrlByApiId(apiId);
		//准备请求参数
		Map<String, String> parametersMap = (Map<String, String>) JSONObject.parse(requestData);
		//通过apiId获得请求方法
		String type = ApiUtil.getRequestTypeByApiId(apiId);
		//发包
		String result = "";
		if("post".equalsIgnoreCase(type)) {
			result = HttpUtil.post(url, parametersMap); 
		}else {
			result = HttpUtil.get(url, parametersMap);
		}
		//结果--》数据回写--》写回到excel中间
		//把result写回数据到某一个excel文档，某个sheet的某行某列
//		ExcelUtil.writeData("target/test-classes/testApiCase.xlsx", 2, "5", 5, result);
		ExcelUtil.dataToWriteList.add(new CellData(caseId, 5, result));
		//断言结果
		System.out.println(result);
	}	
	
	@DataProvider
	public Object[][] getDatas(){
		Object[][] datas = ExcelUtil.readExcel("/testApiCase.xlsx", 2);
		return datas;
	}
	
	public static void main(String[] args) {
/*		Object[][] datas = ExcelUtil.readExcel("/testApiCase.xlsx", 1);
		for (Object[] objects : datas) {
			for (Object object : objects) {
				System.out.println(object);
			}
			System.out.println();
			}*/
		
		String jsonString = "{\"mobilephone\":\"1382222\"}";
		Map<String, String> dataMap = (Map<String, String>) JSONObject.parse(jsonString);
		Set<String> keyset = dataMap.keySet();
		for (String key : keyset) {
			System.out.println(key+"-->"+dataMap.get(key));
		}
		}
	
}
