package week6.day1.assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFileDataEditLead {

	public static String[][] readdatafile() throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./datafiles/EditLead.xlsx");
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowcount = ws.getLastRowNum();
		
		System.out.println(rowcount);
		
		short colcount = ws.getRow(1).getLastCellNum();
		
		System.out.println(colcount);
		
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
