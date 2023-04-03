package locatorsXpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*
 * scenario:
 * open the browser
 * enter myntra.com
 * Type "watches" in search test filed
 * click on search button
 * close browser
 */

public class XpathAttribute {

	public static void main(String[] args) throws InterruptedException {
		//ChromeOptions options=new ChromeOptions(); if any problem to lauch browser in latest version  we can use chrome options
		//options.addArguments("--remote-allow-origins*");
		//WebDriver driver=new ChromeDriver(options);
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("watches");
		driver.findElement(By.xpath("//a[@class=\"desktop-submit\"]")).click();
		Thread.sleep(2000);
		 if(driver.getTitle().contains("Watches - Buy Wrist Watches for Men & Women Online | Myntra"))
			 System.out.println("Test Pass");
		 else
			 System.out.println("Test failed");
		 driver.quit();
			 
		

	}

}
