package com.sundeepmachado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.validator.routines.checkdigit.ISINCheckDigit;

public class App {

	public static void main(String[] args) throws IOException {

		long lStartTime = new Date().getTime();
		ArrayList<String> isinvalidity = new ArrayList<String>();
		ISINCheckDigit digit = new ISINCheckDigit();
		ExcelLoader xls = new ExcelLoader();
		ArrayList<String> isinarray = new ArrayList<String>();
		isinarray = xls.readValues("data.xlsx");
		System.out.println("Processing the ISIN values in excel file");
		xls.copyFileUsingJava7Files();
		xls.clearCellValues(isinarray.size(), 1);

		for (int i = 0; i < isinarray.size(); i++) {
			Boolean boolvalue = digit.isValid((String) isinarray.get(i));
			if (boolvalue) {
				isinvalidity.add("Valid");
			} else {
				isinvalidity.add("Invalid");
			}
		}
		xls.writeValues(isinarray.size(), isinarray, isinvalidity);
		long lEndTime = new Date().getTime();
		long difference = lEndTime - lStartTime;
		System.out.println("Elapsed milliseconds: " + difference);
	}

}
