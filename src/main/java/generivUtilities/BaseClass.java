package generivUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.CreateNewLeadPage;
import pompages.DuplicatingLeadPage;
import pompages.HomePage;
import pompages.LeadPage;
import pompages.LoginPage;
import pompages.NewLeadInfoPage;

public class BaseClass {
	protected propertiesutiility property;
	protected Excelutility excel;
	protected JavaUtility javautil;
	protected Webdriverutility web;
	protected WebDriver driver;
	protected long time;
	protected LoginPage login;
	protected HomePage home;
	protected LeadPage leads;
	protected CreateNewLeadPage createLead;
	protected NewLeadInfoPage leadInfo;
	protected DuplicatingLeadPage duplicateLead;
	public static JavaUtility SjavaUtil;
	public static WebDriver Sdriver;
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetup() {
		property=new propertiesutiility();
		excel=new Excelutility();
		javautil=new JavaUtility();
		SjavaUtil=javautil;
		web=new Webdriverutility();
		property.propertiesInitialization(Autoconstantpath.properties_PATH);
		String url=property.getDataFromproperties("url");
		String browser=property.getDataFromproperties("browser");
		time=Long.parseLong(property.getDataFromproperties("timeouts"));
		driver = web.openAppication(browser,url,time);
		Sdriver=driver;
		}
	
	@BeforeMethod
	public void  methodSetup() {
		login=new LoginPage(driver);
		Assert.assertTrue(login.getLoginButton().isDisplayed());
		home=new HomePage(driver);
		leads=new LeadPage(driver);
		createLead=new CreateNewLeadPage(driver);
		leadInfo =new NewLeadInfoPage(driver);
		duplicateLead=new DuplicatingLeadPage(driver);
		excel.excelInitialization(Autoconstantpath.Excel_PATH);
		login.loginToVtiger(property.getDataFromproperties("username"), property.getDataFromproperties("password"));
	    Assert.assertEquals(home.getPageHeaderText(),"Home");
	    }
	
	
	//@AfterSuite
	//@AfterTest
	@AfterMethod
	public void methodTeardown() {
		home.SignOutVtiger(web);
		
		excel.closeWorkbook();
		}
	@AfterClass
	public void classTeardown() {
		web.closeBrowser();
	}
	
	

}

