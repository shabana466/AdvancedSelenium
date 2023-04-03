package generivUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriverutility {
	private WebDriver driver;
	private Actions actions;
	private Select select;
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		case "chrome" :ChromeOptions options=new ChromeOptions();
		options.addArguments("---remote-allow-origins=*");
			driver =new ChromeDriver(options);break;
		case "firefox":
			driver =new FirefoxDriver();break;
		case "edge":
			driver =new EdgeDriver();break;
			default:System.out.println("Invalid Browser data");
		}
		return driver;
		}
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	public void waitTillElementFound(long time,WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public WebDriver openAppication(String browser, String url, long time) {
		WebDriver driver=launchBrowser(browser);
		maximizeBrowser(driver);
		navigateToApplication(url);
		waitTillElementFound(time, driver);
		return driver;
		
	}
	//explicite wait//overloading method
	public void expliciteWait(WebDriver driver,long time, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, (time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void expliciteWait(WebDriver driver,WebElement element,long time) {
		WebDriverWait wait=new WebDriverWait(driver, (time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  void expliciteWait(WebDriver driver,String title,long time) {
		WebDriverWait wait=new WebDriverWait(driver, (time));
		wait.until(ExpectedConditions.titleContains(title));
	}
	//actionclass---mouse actions
	public void mouseHover(WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void doubleClickElement(WebElement element) {
		actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}	
	public void rigthClickElement(WebElement element) {
		actions=new Actions(driver);
		actions.contextClick(element).perform();
	}	
	public void dragAndDrop(WebElement element, WebElement dest, WebElement src) {
		actions=new Actions(driver);
		actions.dragAndDrop(src,dest).perform();
	}	
	//Select class...dropdownmenu

	public void dropDown(WebElement element, String value) {
		select=new Select(element);
	    select.selectByValue(value);
	}
	public void dropDown(WebElement element, int index) {
		select=new Select(element);
	    select.selectByIndex(index);
	}
	public void dropDown(String text,WebElement element) {
		select=new Select(element);
	    select.selectByVisibleText(text);
	}
	//Handling to frame
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public void switchToFrame( String idorNameAttribute) {
		driver.switchTo().frame(idorNameAttribute);
	}
	public void switchBackFromElement() {
		driver.switchTo().defaultContent();
	}
	//handle to scrollbar
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(true)",element);
	}
	//TakeScreenShot
	public String getScreenShot(JavaUtility javaUtil, String testName ,WebDriver driver) {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File desc=new File("./Screenshot/"+testName+"_"+javaUtil.getCurrentTime()+".png");
	  try {
		FileUtils.copyFile(src, desc);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return desc.getAbsolutePath();
	      
	}
	//handling Alert pops
	public void handleAlert(String status) {
		if(status.equals("ok"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
		}
	//handing childbrowserpop
	public void handleChildBrowser(String expectedTile) {
		Set<String> windows=driver.getWindowHandles();
		for(String windowId:windows) {
			driver.switchTo().window(windowId);
			String title=driver.getTitle();
			if(title.contains(expectedTile))
				break;
				}
	}
	public void switchToParentWindow() {
	String parentID = driver.getWindowHandle();
driver.switchTo().window(parentID);
	}
	public void closeBrowser() {
		driver.quit();
	}

	
}

