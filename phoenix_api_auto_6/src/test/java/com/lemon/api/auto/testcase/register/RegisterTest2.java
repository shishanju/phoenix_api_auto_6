package com.lemon.api.auto.testcase.register;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto.CellData;
import com.lemon.api.auto.util.*;
import okhttp3.ResponseBody;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import retrofit2.Call;
import com.lemon.api.auto.util.AbstractTestBase;

public class RegisterTest2 {

	@Autowired
	apiAction apiAction;

	@Test(dataProvider="Data", dataProviderClass = DataProviders.class)
	public void test(String comments, JSONObject request, JSONObject expResult) {
		System.out.println(comments);
		System.out.println(request);
		System.out.println(expResult);
		Call<ResponseBody> call = apiAction.ali(request);
		ResultMap response = getResponse(call);
	}

}
