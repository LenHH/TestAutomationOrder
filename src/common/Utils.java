package common;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Utils {
public static String[][] getDataFromExcel(String xlFilePath, String sheetName, String tableName) {
		String[][] resultData = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int rowNumber = sheet.getRows();
			int colNumber = sheet.getColumns();
			resultData = new String[rowNumber-1][colNumber];
			

			for (int i = 0; i < rowNumber -1; i++) {
				for (int j = 0; j < colNumber; j++) {
					resultData[i][j] = sheet.getCell(j, i+1).getContents();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (resultData);
	}}
