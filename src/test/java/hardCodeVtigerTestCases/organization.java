package hardCodeVtigerTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class organization {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		//login button displayed or not
		WebElement submitButton=driver.findElement(By.id("submitButton"));
		if(submitButton.isDisplayed())
		{
			System.out.println("Login button is displayed");
		}
		else
		{
			System.out.println("login button is not displayed");
		}
		submitButton.click();
		//verify home page 

		String headerXpath = "//a[@class='hdrLink']";
		WebElement homePageHeader = driver.findElement(By.xpath(headerXpath));
		if(homePageHeader.getText().trim().equals("Home"))
			System.out.println("Home page Displayed");
		else
			System.out.println("Home page not found");
	//click on organization module
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	//verify orga page is displayed or not
	WebElement organizationHeader = driver.findElement(By.xpath("(//a[.='Organizations'])[2]"));
	if(organizationHeader.getText().trim().equals("Organizations")) 
		System.out.println("Organizations page is displayed");
		
	
	else 
		System.out.println("Organizations page is  not displayed");
		
	
	//Click on + Button
	  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 WebElement subPageHeader =driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	 if(subPageHeader.getText().trim().equals("Creating New Organization"))
	 
		 System.out.println("Creating New Organization is displayed");
	 
	 else
	 
		 System.out.println("Creating New Organization is  not displayed");
	 
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("AMDOCS");
	WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industry']"));
	Select industry=new Select(industryDropdown);
	industry.selectByValue("Communications");
	     WebElement typeDropdown = driver.findElement(By.xpath("//select[@name='accounttype']"));
	Select type=new Select(typeDropdown);
	type.selectByValue("Partner");
	
	driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	WebElement newOrgInfoHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	//verify Organization is created or not
	if(newOrgInfoHeader.getText().contains("AMDOCS"))
			System.out.println("Organization is created");
	else
		System.out.println("Organization is  not created");
	//click on delete button
	driver.findElement(By.xpath("//input[@name='Delete']")).click();
	Alert alert=driver.switchTo().alert();
	 alert.accept();
	 //verify organization added or not in DB
	WebElement organizationname= driver.findElement(By.xpath("//table[@class='lvt small']//tr//td[3]//a[text()='Organization Name']"));
	 if(organizationname.getText().equals("AMDOCS"))
		 System.out.println("organization is added in DB");
	 else
		 System.out.println("organization is  not added in DB");
	 //click on sign out button
	 Actions a = new Actions(driver);
		WebElement adminIcon = driver.findElement(By.xpath(
				"//img[@src=\"themes/softed/images/user.PNG\"]"));
		a.moveToElement(adminIcon).perform();
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		driver.quit();

	 
	  

}
}
