package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("test321");
		Row row;
		Map<String, Object[]> studentData = new TreeMap<String, Object[]>();
		studentData.put("1", new Object[] { "userName", "operatorId", "pwd" });
		studentData.put("2", new Object[] { "praveen", "pooja", "leela" });
		studentData.put("3", new Object[] { "praveen2", "pooja2", "leela2" });
		studentData.put("4", new Object[] { "praveen2", "pooja2", "leela2" });
		studentData.put("5", new Object[] { "praveen2", "pooja2", "leela2" });

		Set<String> k = studentData.keySet();
		int rowCount = 0;
		for (String string : k) {
			int colCount = 0;
			row = sheet.createRow(rowCount);
			Object[] i = studentData.get(string);

			for (Object string2 : i) {
				Cell c = row.createCell(colCount++);
				c.setCellValue((String) string2);

				System.out.println(string2);
			}
			rowCount++;
		}

		FileOutputStream f = new FileOutputStream(
				"C:\\Users\\91812\\eclipse-workspace\\ProjectSat\\src\\main\\resources\\testData\\test_infy.xlsx");
		wb.write(f);
		f.close();
	}

}
