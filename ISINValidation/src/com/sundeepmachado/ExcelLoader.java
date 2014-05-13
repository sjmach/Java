package com.sundeepmachado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLoader {

	public static String datafilename = System.getProperty("user.dir")
			+ "\\data.xlsx";
	public static String resultfilename = System.getProperty("user.dir")
			+ "\\result.xlsx";

	public ArrayList<String> readValues(String filename) throws IOException {
		ArrayList<String> isinarray = new ArrayList<String>();
		try {
			FileInputStream file = new FileInputStream(new File(datafilename));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				if (!(row.getRowNum() == 0)) {
					Cell firstCell = row.getCell(0);
					isinarray.add(firstCell.toString());
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return isinarray;
	}

	public void clearCellValues(int rownum, int columnnum) throws IOException {
		FileInputStream file = new FileInputStream(new File(resultfilename));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row r = sheet.getRow(rownum);
		r = sheet.createRow(rownum);
		Cell isinc = r.getCell(columnnum);
		if (isinc == null) {
			isinc = r.createCell(columnnum, Cell.CELL_TYPE_STRING);
		}
		isinc.setCellValue("");
		FileOutputStream fileout = new FileOutputStream(resultfilename);
		workbook.write(fileout);
		fileout.close();
	}

	public void copyFileUsingJava7Files() throws IOException {
		File source = new File(datafilename);
		File dest = new File(resultfilename);

		if (dest.exists()) {
			if (!(dest.delete())) {
				System.out
						.println(dest.getName()
								+ " is not deleted! Please delete it manually or close it");
				System.exit(1);
			}
		}
		Files.copy(source.toPath(), dest.toPath());

	}

	@SuppressWarnings("rawtypes")
	public void writeValues(int isinarraysize, ArrayList isinvalues,
			ArrayList isinvalidity) throws IOException {

		FileInputStream file = new FileInputStream(new File(resultfilename));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 0; i < isinarraysize; i++) {
			int rownum = i;
			Row r = sheet.getRow(rownum); //
			r = sheet.createRow(rownum);
			Cell isinc = r.getCell(0);
			if (isinc == null) {
				isinc = r.createCell(0, Cell.CELL_TYPE_STRING);
			}
			String isinvalue = (String) isinvalues.get(i);
			isinc.setCellValue(isinvalue);
			Cell isinvalid = r.getCell(1);
			if (isinvalid == null) {
				isinvalid = r.createCell(1, Cell.CELL_TYPE_STRING);
			}
			String validity = (String) isinvalidity.get(i);
			isinvalid.setCellValue(validity);
		}
		FileOutputStream fileout = new FileOutputStream(resultfilename);
		workbook.write(fileout);
		fileout.close();

	}

}
