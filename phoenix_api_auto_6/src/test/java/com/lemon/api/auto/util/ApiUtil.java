package com.lemon.api.auto.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lemon.api.auto.ApiInfo;

public class ApiUtil {
	//存放api基本信息的容器
	private static Map<String, ApiInfo> apiInfoMap = new HashMap<String, ApiInfo>();
	
		static {
		Object[][] datas = ExcelUtil.readExcel("/testApiCase.xlsx", 1);
		for (Object[] dataArray : datas) {
			ApiInfo apiInfo = new ApiInfo();
			String apiId = dataArray[0].toString();
			String apiName = dataArray[1].toString();
			String Type = dataArray[2].toString();
			String url = dataArray[3].toString();
			apiInfo.setApiId(apiId);
			apiInfoMap.put(apiId, apiInfo);
				
		}
	}
		
		/**
		 * 通过apiId找到对于的Url
		 * 通过一个key找到对于的值
		 * key-->apiId
		 * value-->api基本信息中的url字段
		 * @param apiId
		 * @return
		 */
	public static String getUrlByApiId(String apiId) {
		return apiInfoMap.get(apiId).getUrl();
	}

	/**   
	 * 通过apiId获得请求方法
	 * @param apiId
	 * @return
	 */
	public static String getRequestTypeByApiId(String apiId) {
		return apiInfoMap.get(apiId).getType();
	}

	public static void main(String[] args) {
		Set<String> keyset = apiInfoMap.keySet();
		for (String key : keyset) {
			System.out.println(key+"-->"+apiInfoMap.get(key));
		}
	}
	
}
