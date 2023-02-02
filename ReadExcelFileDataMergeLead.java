package week6.day1.assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileDataMergeLead {

	public static String[][] mergeLead() throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./datafiles/MergeLead.xlsx");
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowcount = ws.getLastRowNum();
		
		short colcount = ws.getRow(1).getLastCellNum();
		
		String[][] data = new String[rowcount][colcount];
		
		  for (int i = 1; i <= rowcount; i++) { 
			  for (int j = 0; j < colcount; j++) {
				  String cellvalue = ws.getRow(i).getCell(j).getStringCellValue();
				  data[i-1][j]=cellvalue;
					//System.out.println(cellvalue);
		  } 
			  }
		 
		wb.close();
		
		return data;
		
		

	}

}
