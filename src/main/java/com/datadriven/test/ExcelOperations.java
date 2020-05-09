package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {

		// Get test data from excel
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Yogesh\\eclipse-workspace\\Java Training\\DataDrivenFW-Part2\\src\\main\\java\\com\\testdata\\Yahooform2.xlsx");

		if (!reader.isSheetExist("HomePage")) {
			reader.addSheet("HomePage");

		
	}

	// To count total no of Col
	int colCount = reader.getColumnCount("RegTestData");
	System.out.println("Total No of col is==> "+colCount );
	
	// To count total no of Row
	int rowCount = reader.getRowCount("RegTestData");
	System.out.println("Total No of Row Count is==> "+rowCount);
	
	//To get the row no of any cell(data)
	int rowNum = reader.getCellRowNum("RegTestData", "FirstName", "Akshay");
		System.out.println("Row No is:==>" + rowNum);
		
		//or you can write above state like:
		
		System.out.println(reader.getCellRowNum("RegTestData", "FirstName", "Sunil"));
		
	}
}
