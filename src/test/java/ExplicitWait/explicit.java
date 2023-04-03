package ExplicitWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Timeout;

public class explicit {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().wait(10,TimeUnit.SECONDS);
		            
		            //to wait until title appears
		            
		            wait.until(ExpectedConditions.titleContains("actiTIME - Login"));
		            
		                 WebElement username = driver.findElement(By.id("username"));
		                 
		                         //wait until username text feild appears
		                 
		                 wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("admin");
		                            
		               WebElement password = driver.findElement(By.name("pwd"));
		               
		               //to wait until password password text feild
		               
		               wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("manager");
		               
		              WebElement login = driver.findElement(By.xpath("(//div[contains(text(),\"Login \")])[1]"));
		                 
		                 //to wait until login button appaers
		                 
		                 wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		                 
		                 //to wait until  home page appears
		                 
		                 wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		                 
		                 //to wait until home page appers
		                 
		                wait.until(ExpectedConditions.titleContains("Enter Time-Track"));
		                 
		                // driver.quit();
		
		
		
		

	}

}
