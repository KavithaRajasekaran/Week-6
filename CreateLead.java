package week6.day1.assignments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass{
	
	@Test(dataProvider="newLead")
	public void runCreateLead(String compname, String fname, String lname) {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(compname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
		
}
	
	@DataProvider(name="newLead")
	private String[][] leadData() throws IOException 
	{
		/*
		 * String[][] data = new String[3][3];
		 * 
		 * data[0][0]="Testleaf"; data[0][1]="Kavitha"; data[0][2]="R";
		 * 
		 * data[1][0]="Salesforce"; data[1][1]="Kavitha"; data[1][2]="Raj";
		 * 
		 * data[2][0]="Leaftaps"; data[2][1]="Kavitha"; data[2][2]="Raja";
		 * 
		 * return data;
		 */
		
		String[][] readdatafile = ReadExcelFileDataCreateLead.readdatafile();
		
		return readdatafile;
		
	}
}






