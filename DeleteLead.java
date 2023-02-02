package week6.day1.assignments;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DeleteLead extends BaseClass{
	
	@Test(dataProvider="deleteLead")
	public void runDeleteLead(String phonenumb) throws InterruptedException {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();

		driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumb);

		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		//Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@unselectable='on'])[1]")).click();
		Thread.sleep(4000);

		WebElement leadtableelement = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String leadID = leadtableelement.getText();
		System.out.println("The Lead ID value is " + leadID);
		leadtableelement.click();

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();

		driver.findElement(By.partialLinkText("Find Leads")).click();

		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[6]")).click();
		
		//System.out.println("The lead is deleted");
		
		
		Thread.sleep(3000);
		
		boolean flag = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		
		if(!flag)
		{
			System.out.println("The deletion is unsuccessfull. We still see the leadID in the table");
		}
		else
		{
			System.out.println("The deletion is successfull. We dont see the leadID in the table");
		} 
		
	}
	
	@DataProvider(name="deleteLead")
	private String[][] deleteLead() throws IOException {
		
		String[][] deleteLead = ReadExcelFileDataDeleteLead.deleteLead();
		
		return deleteLead;

	}
}






