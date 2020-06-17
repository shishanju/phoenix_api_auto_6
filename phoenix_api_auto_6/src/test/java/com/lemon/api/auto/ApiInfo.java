package com.lemon.api.auto;

public class ApiInfo {
	
	//ApiId(接口编号)	
	private String ApiId;
	//ApiName(接口名称)	
	private String ApiName;
	//Type(接口提交方式)	
	private String Type;
	//Url(接口地址)
	private String url;

	public String getApiId() {
		return ApiId;
	}
	public void setApiId(String apiId) {
		ApiId = apiId;
	}
	public String getApiName() {
		return ApiName;
	}
	public void setApiName(String apiName) {
		ApiName = apiName;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "ApiInfo [ApiId=" + ApiId + ", ApiName=" + ApiName + ", Type=" + Type + ", url=" + url + "]";
	}

}
