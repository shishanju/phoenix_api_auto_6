package com.lemon.api.auto.base;

import org.testng.annotations.AfterSuite;

import com.lemon.api.auto.util.ExcelUtil;

public class BastTester {

	@AfterSuite
	public void afterSuite() {
		//读取某个excel文档，一次性写回数据到目标文件
		ExcelUtil.batchWriteDatas("src/test/resources/testApiCase.xlsx", "target/testApiCase.xlsx", 2);
		/**
		 * 1:需要一个容器：static 全局
		 * 2：容器中数据的类型
		 */
	}
}
