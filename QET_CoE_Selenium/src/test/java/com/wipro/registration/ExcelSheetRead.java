package com.wipro.registration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetRead {
	FileInputStream file;
	Workbook wrkbk;
	Sheet sheet;
	Cell cell;
	String fileextension;
	
	public ExcelSheetRead(String excelname, String excelpath)throws IOException{
		file = new FileInputStream(excelpath);
		fileextension = excelname.substring(excelname.indexOf("."));
		if(fileextension.equals(".xls")) {
			wrkbk = new HSSFWorkbook(file);
		}else {
			wrkbk=new XSSFWorkbook(file);
		}
		
	}
	
	public String getRegData(int sheetindex, int row, int column) {
		sheet=wrkbk.getSheetAt(sheetindex);
		cell=sheet.getRow(row).getCell(column);
		if(cell.getCellType()==CellType.NUMERIC) {
			return String.valueOf((long)cell.getNumericCellValue());
			
		}else {
			return cell.getStringCellValue();
		}
		
	}
	public int RowCount(int sheetindex) {
		return (wrkbk.getSheetAt(sheetindex).getLastRowNum())+1;
	}
	public int ColumnCount(int sheetindex) {
		return wrkbk.getSheetAt(sheetindex).getRow(0).getLastCellNum();
		}
	
	
}
