package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider1 {
	@DataProvider(name = "data_book1")
	public String[][] dataPro() throws IOException {
		String file = System.getProperty("user.dir") + "//TestData//Book1.xlsx";

		ExcelUtilities excel = new ExcelUtilities();

		int rowCount = excel.rowCount(file, "Sheet1");
		int colCount = excel.colCount(file, "Sheet1");

		String data[][] = new String[rowCount][colCount];

		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			for (int colNo = 0; colNo < colCount; colNo++) {
				data[rowNo - 1][colNo] = excel.cellData(file, "Sheet1", rowNo, colNo);
			}
		}
		return data;
	}

	@DataProvider(name = "data_book1_user")
	public String[] dataUsers() throws IOException {
		String file = System.getProperty("user.dir") + "//TestData//Book1.xlsx";

		ExcelUtilities excel = new ExcelUtilities();

		int rowCount = excel.rowCount(file, "Sheet1");
//		int colCount = excel.colCount(file, "Sheet1");

		String[] dataUser = new String[rowCount];

		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			dataUser[rowNo - 1] = excel.cellData(file, "Sheet1", rowNo, 1);
		}
		return dataUser;
	}

}
