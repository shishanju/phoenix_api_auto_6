package com.lemon.api.auto.util;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lemon.api.auto.SQLChecker;

public class SQLCheckUtil {

	public static void main(String[] args) {
		String sql = "[\"{\"no\":\"1\",\"sql\":\"select count(*) as count from member where mobilephone=13800000000\",\"exceptedResult\":[{\"count\":\"1\"}]\"}";
		List<SQLChecker> sqlCheckers = JSONObject.parseArray(sql, SQLChecker.class);
		for (SQLChecker sqlChecker : sqlCheckers) {
			System.out.println(sqlChecker);    
		}
	}
}
