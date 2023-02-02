package week6.day1.assignments;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class EditLead extends BaseClass{

	@Test(dataProvider="editLead")
	public void runEditLead(String compname) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(compname);
		driver.findElement(By.name("submitButton")).click();
	}
	
	@DataProvider(name="editLead")
	private String[][] editleadData() throws IOException 
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
		
		String[][] readdatafile = ReadExcelFileDataEditLead.readdatafile();
		
		return readdatafile;
		
	}
}






