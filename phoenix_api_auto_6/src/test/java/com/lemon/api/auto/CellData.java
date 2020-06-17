package com.lemon.api.auto;

public class CellData {

	//要写回excel的数据：行、列、要写的1数据--》CellData
	
	//测试用例的id
	private String caseId;
	//列号
	private int cellNum;
	//要写的数据
	private String dataStr;

	public String getCasgId() {
		return caseId;
	}
	public void setCasgId(String casgId) {
		this.caseId = casgId;
	}
	public int getCellNum() {
		return cellNum;
	}
	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}

	@Override
	public String toString() {
		return "CellData [casgId=" + caseId + ", cellNum=" + cellNum + ", dataStr=" + dataStr + "]";
	}
	public CellData(String casgId, int i, String dataStr) {
		super();
		this.caseId = casgId;
		this.cellNum = i;
		this.dataStr = dataStr;
	}
	
	
}