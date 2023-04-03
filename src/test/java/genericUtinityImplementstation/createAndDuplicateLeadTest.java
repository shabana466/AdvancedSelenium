package genericUtinityImplementstation;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import generivUtilities.Autoconstantpath;
import generivUtilities.Excelutility;
import generivUtilities.JavaUtility;
import generivUtilities.Webdriverutility;
import generivUtilities.propertiesutiility;


public class createAndDuplicateLeadTest {

	public static void main(String[] args) {
		propertiesutiility property=new propertiesutiility();
		Excelutility excel=new Excelutility();
		JavaUtility javautil=new JavaUtility();
		Webdriverutility web=new Webdriverutility();
		property.propertiesInitialization(Autoconstantpath.properties_PATH);
		excel.excelInitialization(Autoconstantpath.Excel_PATH);
		String url=property.getDataFromproperties("url");
		String browser=property.getDataFromproperties("browser");
		long time=Long.parseLong(property.getDataFromproperties("timeouts"));
		WebDriver driver = web.openAppication(browser,url,time);
		
		
		//verify login button displayed or not
		         WebElement loginButton = driver.findElement(By.id("submitButton"));
		         if(loginButton.isDisplayed())
		        	 System.out.println("login page displayed");
		         else
		        	 System.out.println("login page not displayed");
		         //login application with credentials
		         driver.findElement(By.name("user_name")).sendKeys(property.getDataFromproperties("usernsme"));
		         driver.findElement(By.name("user_password")).sendKeys(property.getDataFromproperties("password"));
		         loginButton.click();
		         //verify home page displayed or not
		        String headerXpath = "//a[@class='hdrLink']";
		           WebElement homePageHeader = driver.findElement(By.xpath(headerXpath));
		           if(homePageHeader.getText().trim().equals("Home"))
		           System.out.println("home page displayed");
		           else
		        	   System.out.println("home page not found");
		           //click on lead module
		           driver.findElement(By.xpath("//a[text()='Leads']")).click();
		           //verify lead home page displayed or not
		           WebElement leadPageHeader = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		           
		        	   if(leadPageHeader.getText().trim().equals("Leads"))
		        		   System.out.println("lead page displayed");
		        	   else
		        		   System.out.println("lead page  not found");
		        	   //create click on + icon new lead creation
		        	   driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		        	   String subPageHeader = "//span[@class='lvtHeaderText']";
		   WebElement createNewLeadInfoHeader = driver.findElement(By.xpath(subPageHeader));
		   if(createNewLeadInfoHeader.getText().trim().equals("Creating New Lead"))
			   System.out.println("Creating New Lead page is displayed");
		   else
			   System.out.println("Creating New Lead page is  not displayed");
		   //to get data form excel
		   Map<String,String> map=excel.readDataFromExcel("LeadsTestData","Create and Duplicate Lead");
		   String LastName = map.get("Last Name")+javautil.generateRandomNumber(100);
		   String company=map.get("company")+javautil.generateRandomNumber(100);
		   driver.findElement(By.className("lastname")).sendKeys(map.get("Last Name"));
		   driver.findElement(By.name("company")).sendKeys(map.get("Company"));
		   driver.findElement(By.xpath("(//input[@value=\"  Save  \"])[1]")).click();
		 WebElement newLeadInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		   if(newLeadInfoHeader.getText().contains(LastName))
			   System.out.println("Lead Created");
		   else
			   System.out.println("Lead not Found");
		   //click on duplicate button after created lead
		   driver.findElement(By.xpath("//input[@value='Duplicate']")).click();
		   WebElement duplicatingHeader = driver.findElement(By.xpath(subPageHeader));
		   if(duplicatingHeader.getText().contains("Duplicating"))
		   System.out.println("Duplicating Page is Displayed");
		   else
			   System.out.println("Duplicating Page is not Displayed");
		   //to get data  last name from excel sheet
		  String newLastName = map.get("New Last Name")+javautil.generateRandomNumber(100);
		       WebElement newLastNameTF = driver.findElement(By.name("lastname"));
		       newLastNameTF.clear();
		       newLastNameTF.sendKeys("newLastName");
		       driver.findElement(By.xpath("(//input[@value=\"  Save  \"])[1]")).click();
		       WebElement duplicateLeadInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			   if(duplicateLeadInfoHeader.getText().contains(newLastName))
				   System.out.println("Lead duplicated");
			   else
				   System.out.println("Lead not duplicated");
			   driver.findElement(By.xpath(headerXpath)).click();
			   //move to adminIcon
			  WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 //click on adminicon
			  web.mouseHover(adminIcon);
			  //signout application
			  driver.findElement(By.xpath("//a[.='Sign Out']"));
			  //close browser
			 web.closeBrowser();
			 excel.closeWorkbook();
		           
	}

}
