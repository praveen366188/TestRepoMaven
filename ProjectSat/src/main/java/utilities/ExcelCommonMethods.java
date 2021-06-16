package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommonMethods {

	XSSFWorkbook wb;
	File io;
	FileInputStream in;

	public ExcelCommonMethods(String path) {
		io = new File(path);
		try {
			in = new FileInputStream(io);
			wb = new XSSFWorkbook(in);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String readDataFromExcel(String sheetName, int row, int col) {
		XSSFSheet sheet = wb.getSheet(sheetName);
		return sheet.getRow(row).getCell(col).getStringCellValue();

	}
	
	public void writeDataFromExcel(String sheetName,String cellValue) {
		XSSFSheet sheet = wb.getSheet(sheetName);
int lastRowCount=sheet.getLastRowNum();
		Row r=sheet.createRow(lastRowCount);
		Cell c=r.createCell(0);
		c.setCellValue(cellValue);
		
		
		
		
	}

}
