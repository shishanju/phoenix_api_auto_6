package com.lemon.api.auto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.lemon.api.auto.CellData;

public class ExcelUtil {
	
	public static List<CellData> dataToWriteList = new ArrayList<CellData>();
	
	
	public static void main(String[] args) {
		writeData("/testApiCase.xlsx", 2, "5", 5, "hello");
	}

	
	public static Object[][] readExcel(String excelPath, int sheetIndex){
		//创建一个二维数组
		Object[][] datas = null;
		try {
			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			Workbook workbook = WorkbookFactory.create(inp);
			//获取所需要的sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex - 1); 
			//得到所有的行，从0开始
			int lastRowNum = sheet.getLastRowNum();
			//把得到的值放在二维数组中
			datas = new Object[lastRowNum][];
			//循环遍历所有的行
			for (int i = 1; i <= lastRowNum; i++) {
				//得到每一列
				Row row = sheet.getRow(i);
				//得到每一列从1开始
				int lastCellNum = row.getLastCellNum();
				//创建一个一维数组把值放进去
				Object[] cellValueArray = new Object[lastCellNum];
				//遍历每一列的值
				for (int j = 0; j < lastCellNum; j++) {
					 Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					 //设置每一列的属性
					 cell.setCellType(CellType.STRING);
					 //得到cellValue
					 String cellValue = cell.getStringCellValue();
					 //System.out.println(cellValue + ",");
					 //赋值给一维数组
					cellValueArray[j] = cellValue;
				}
				datas[i - 1] = cellValueArray;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	public static Object[][] readExcel(String excelPath, int sheetIndex, int startRow, int endRow, int startCell, int endCell) {
		try {
			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(sheetIndex - 1);
			Object[][] datas = null;
			for (int i = startRow; i <= endRow; i++) {
				Row row = sheet.getRow(i - 1);
				for (int j = startCell; j <= endCell; j++) {
					Cell cell = row.getCell(j - 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String  cellValue = cell.getStringCellValue();
					System.out.println(cellValue+ ",");
					datas[i-startRow][j-startCell] = cellValue;
				}
				System.out.println();
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 
	 * @param excelPath	读取的文档
	 * @param sheetNum	sheet索引号
	 * @param caseId	case的唯一标识
	 * @param cellNum	要写的列号,从第1列开始
	 * @param result	回写的数据
	 */
	@Deprecated
	public static void writeData(String excelPath, int sheetNum, String caseId, int cellNum, String result) {
		InputStream inp = null;
		OutputStream outputStream = null;
		Workbook workbook = null;
		try {
			//InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			inp = new FileInputStream(new File(excelPath));	
			workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(sheetNum - 1);
			//遍历所有的行，获得每一行的第一列，获得该列的值与caseId比对，如果相当这就是要回写的目标行
			//获得最大的行号
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 1; i <= lastRowNum; i++) {
				//得到当前遍历的行
				Row row = sheet.getRow(i);
				//获得第一列
				Cell firstCell = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				firstCell.setCellType(CellType.STRING);
				//得到第一列的值
				String cellValue = firstCell.getStringCellValue();
				if (caseId.equals(cellValue)) {
					Cell cellToBeWrite = row.getCell(cellNum-1,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellToBeWrite.setCellType(CellType.STRING);
					cellToBeWrite.setCellValue(result);
					break; //结束循环，因为已经匹配上了
					
				}
			}
			//输出流
			outputStream = new FileOutputStream(new File(excelPath));
			//回写
			workbook.write(outputStream);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inp != null) {
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}


	/**
	 * 批量回写
	 * @param sourceExcelPath	源文件路径
	 * @param targetExcelPath	目标文件路径
	 * @param sheetNum	sheet的num
	 */
	public static void batchWriteDatas(String sourceExcelPath, String targetExcelPath, int sheetNum) {
		//批量回写
		InputStream inp = null;
		OutputStream outputStream = null;
		Workbook workbook = null;
		try {
			//InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			inp = new FileInputStream(new File(sourceExcelPath));	
			workbook = WorkbookFactory.create(inp);
			//读取相对应的sheet
			Sheet sheet = workbook.getSheetAt(sheetNum - 1);
			//最大的行号
			int lastRowNum = sheet.getLastRowNum();
			
			//循环来写容器中间的数据
			for (CellData cellData : dataToWriteList) {
				//要写的cell相关数据
				String caseId = cellData.getCasgId();
				int cellNum = cellData.getCellNum();
				String dataStr = cellData.getDataStr();			
				//遍历所有行
				for (int i = 1; i <= lastRowNum; i++) {
					//得到当前遍历的行
					Row row = sheet.getRow(i);
					//获得第一列
					Cell firstCell = row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					firstCell.setCellType(CellType.STRING);
					//得到第一列的值
					String cellValue = firstCell.getStringCellValue();
					if (caseId.equals(cellValue)) {
						Cell cellToBeWrite = row.getCell(cellNum-1,MissingCellPolicy.CREATE_NULL_AS_BLANK);
						cellToBeWrite.setCellType(CellType.STRING);
						cellToBeWrite.setCellValue(dataStr);
						break;
					}
			}
		}			
			//输出流
			outputStream = new FileOutputStream(new File(targetExcelPath));
			//回写
			workbook.write(outputStream);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inp != null) {
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

/*	public static Object[][] readExcel(String excelPath, int sheetIndex) {
		Object[][] datas = null;
		try {
			InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
			Workbook workbook = WorkbookFactory.create(inp);
			//获取所用的sheet
			Sheet sheet = workbook.getSheetAt(sheetIndex - 1);
			//得到所有行，从0开始
			int lastRowNum = sheet.getLastRowNum();
			//添加到二位数组
			datas = new Object[lastRowNum][];
			//遍历所有行
			for (int i = 1; i <= lastRowNum; i++) {
				//得到每一列
				Row row = sheet.getRow(i);
				//得到所有列，从1开始
				int getLastCellNum = row.getLastCellNum();
				//new一个一维数组，把值存储进去
				Object[] cellValueArray = new Object[getLastCellNum];
				//遍历所有列
				for (int j = 0; j < getLastCellNum; j++) {
					Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String  cellValue = cell.getStringCellValue();
					System.out.println(cellValue+ ",");
					//datas[][j] = cellValue;
					cellValueArray[j] = cellValue;
				}
				System.out.println();
				datas[i - 1] = cellValueArray;
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}*/

/*	public static Object[][] readExcel1(String excelPath, int sheetIndex) {
		InputStream inp = ExcelUtil.class.getResourceAsStream(excelPath);
		Object[][] datas = null;
		try {
			Workbook workbook = WorkbookFactory.create(inp);
			Sheet sheet = workbook.getSheetAt(sheetIndex -1);
			int lastRowNum = sheet.getLastRowNum();
			datas = new Object[lastRowNum][];
			for (int i = 1; i <= lastRowNum; i++) {
				Row row = sheet.getRow(i);
				int lastCekllNum = row.getLastCellNum();
				Object[] cellValueArray = new Object[lastCekllNum];
				for (int j = 0; j < lastCekllNum; j++) {
					Cell cell = row.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue + ",");
					cellValueArray[j] = cellValue;
				}
				datas[i - 1] = cellValueArray;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}
	*/

}
