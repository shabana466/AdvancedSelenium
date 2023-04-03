package pomImplementation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import generivUtilities.Autoconstantpath;
import generivUtilities.Excelutility;
import generivUtilities.JavaUtility;
import generivUtilities.Webdriverutility;
import generivUtilities.propertiesutiility;
import pompages.CreateNewLeadPage;
import pompages.DuplicatingLeadPage;
import pompages.HomePage;
import pompages.LeadPage;
import pompages.LoginPage;
import pompages.NewLeadInfoPage;

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
		
		LoginPage login=new LoginPage(driver);
		HomePage home=new HomePage(driver);
		LeadPage leads=new LeadPage(driver);
		CreateNewLeadPage createLead=new CreateNewLeadPage(driver);
		NewLeadInfoPage leadInfo =new NewLeadInfoPage(driver);
		DuplicatingLeadPage duplicateLead=new DuplicatingLeadPage(driver);
				
		//verify login button displayed or not
		         
		         if(login.getLoginButton().isDisplayed())
		        	 System.out.println("login page displayed");
		         else
		        	 System.out.println("login page not displayed");
		         //login application with credentials
		        // driver.findElement(By.name("user_name")).sendKeys(property.getDataFromproperties("usernsme"));
		        // driver.findElement(By.name("user_password")).sendKeys(property.getDataFromproperties("usernsme"));
		        // loginButton.click();
		         login.loginToVtiger(property.getDataFromproperties("username"), property.getDataFromproperties("password"));
		         //verify home page displayed or not
		       // String headerXpath = "//a[@class='hdrLink']";
		           //WebElement homePageHeader = driver.findElement(By.xpath(headerXpath));
		           if(home.getPageHeaderText().equals("Home"))
		           System.out.println("home page displayed");
		           else
		        	   System.out.println("home page not found");
		           
		           ////click on lead module
		           home.clickLeadsTab();
		          // driver.findElement(By.xpath("//a[text()='Leads']")).click();
		           ////verify lead home page displayed or not
		          // WebElement leadPageHeader = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		           
		        	   if(leads.getPageHeaderText().equals("Leads"))
		        		   System.out.println("lead page displayed");
		        	   else
		        		   System.out.println("lead page  not found");
		        	   //create clickc on + icon new lead creation
		        	  // driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		        	   leads.clickPlusButton();
		        	  // String subPageHeader = "//span[@class='lvtHeaderText']";
		   //WebElement createNewLeadInfoHeader = driver.findElement(By.xpath(subPageHeader));
		   if(createLead.getPageHeaderText().equals("Creating New Lead"))
			   System.out.println("Creating New Lead page is displayed");
		   else
			   System.out.println("Creating New Lead page is  not displayed");
		   //to get data form excel
		   Map<String,String> map=excel.readDataFromExcel("LeadsTestData","Create and Duplicate Lead");
		   String LastName = map.get("Last Name")+javautil.generateRandomNumber(100);
		   String company=map.get("Company")+javautil.generateRandomNumber(100);
		   //create new lead
		   createLead.setLastName(LastName);
		   createLead.setCompanyName(company);
		   createLead.clicksaveButton();
		   //driver.findElement(By.className("lastname")).sendKeys(map.get("Last Name"));
		   //driver.findElement(By.name("company")).sendKeys(map.get("Company"));
		   //driver.findElement(By.xpath("(//input[@value=\"  Save  \"])[1]")).click();
		// WebElement newLeadInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		   if(leadInfo.getPageHeaderText().contains(LastName))
			   System.out.println("Lead Created");
		   else
			   System.out.println("Lead not Found");
		   //click on duplicate button after created lead
		   leadInfo.clickDuplicateButton();
		   //driver.findElement(By.xpath("//input[@value='Duplicate']")).click();
		   //WebElement duplicatingHeader = driver.findElement(By.xpath(subPageHeader));
		   if(duplicateLead.getPageHeaderText().contains("Duplicating"))
		   System.out.println("Duplicating Page is Displayed");
		   else
			   System.out.println("Duplicating Page is not Displayed");
		   //to get data  last name from excel sheet
		  String newLastName = map.get("New Last Name")+javautil.generateRandomNumber(100);
		       //WebElement newLastNameTF = driver.findElement(By.name("lastname"));
		      // newLastNameTF.clear();
		      // newLastNameTF.sendKeys("newLastName");
		      // driver.findElement(By.xpath("(//input[@value=\"  Save  \"])[1]")).click();
		  duplicateLead.setLastName(newLastName);
		  duplicateLead.clicksaveButton();
		      // WebElement duplicateLeadInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			   if(leadInfo.getPageHeaderText().contains(newLastName))
				   System.out.println("Lead duplicated");
			   else
				   System.out.println("Lead not duplicated");
			   duplicateLead.clickleads();
			 //driver.findElement(By.xpath(headerXpath)).click();
				
				//WebElement newlead = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]"));
				if(leads.getNewLeadName().equals(newLastName)) {
					System.out.println("Lead added to data base");
					excel.writeToExcel("LeadsTestData", "Pass", "Create and Duplicate Lead", Autoconstantpath.Excel_PATH);
				}
				else {
					System.out.println("Lead not added to data base");
					excel.writeToExcel("LeadsTestData", "Fail", "Create and Duplicate Lead", Autoconstantpath.Excel_PATH);
				}
			   //driver.findElement(By.xpath(headerXpath)).click();
			   //move to adminIcon
			 // WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 //click on adminicon
			  //web.mouseHover(adminIcon);
			  //signout application
			  //driver.findElement(By.xpath("//a[.='Sign Out']"));
			  // driver.quit();
			  //close 
home.SignOutVtiger(web);
			 web.closeBrowser();
			 excel.closeWorkbook();
		           
	}

}
