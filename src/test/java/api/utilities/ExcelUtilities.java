package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtilities {
	FileInputStream fi;
	XSSFWorkbook workbook;
	XSSFSheet sheetName;

	public int rowCount(String path, String sheet) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheetName = workbook.getSheet(sheet);
		int lastRow = sheetName.getLastRowNum();
		return lastRow;
	}

	public int colCount(String path, String sheet) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheetName = workbook.getSheet(sheet);
		int lastRow = sheetName.getLastRowNum();
		int lastCol = sheetName.getRow(0).getLastCellNum();
		return lastCol;
	}

	public String cellData(String path, String sheet, int row, int colNo) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheetName = workbook.getSheet(sheet);
		XSSFCell cell = sheetName.getRow(row).getCell(colNo);
		String cellData = cell.toString();
		return cellData;
	}
	
//	@Test
//	public void test1() throws IOException {
//		String file = System.getProperty("user.dir") + "//TestData//Book1.xlsx";
//		String str=cellData(file, "Sheet1", 1, 1);
//		System.out.println(str);
//	}

}
