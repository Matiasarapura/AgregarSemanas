package com.ibm.parser;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLoader {
	static void parcer(String path) {
		try {
			InputStream ExcelFileToRead = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			Iterator rows = sheet.rowIterator();

			while (rows.hasNext()) {

				row = (XSSFRow) rows.next();

				// asignate(row);
				/*
				 * for(int i=0; i<row.getLastCellNum(); i++) { cell =
				 * row.getCell(i, Row.CREATE_NULL_AS_BLANK);
				 * System.out.println(cell.toString()); }
				 */

			}
			// aca se llama a la funcion que sube a la base de datos

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}