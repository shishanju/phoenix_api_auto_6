package com.lemon.api.auto;

public class SQLChecker {

	private String no;
	
	private String sql;
	
	private String exceptedResult;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getExceptedResult() {
		return exceptedResult;
	}

	public void setExceptedResult(String exceptedResult) {
		this.exceptedResult = exceptedResult;
	}

	@Override
	public String toString() {
		return "SQLChecker [no=" + no + ", sql=" + sql + ", exceptedResult=" + exceptedResult + "]";
	}
	
	
}
