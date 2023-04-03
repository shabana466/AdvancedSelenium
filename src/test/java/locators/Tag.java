package locators;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPathExpression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://demo.actitime.com/login.do");
		//Thread.sleep(2000);
		//driver.findElement(By.linkText("Clothing")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.partialLinkText("Bags"));
		//driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//label[contains(text(),\"Keep me logged in\")]")).click();
		driver.findElement(By.xpath("//nobr[contains(text(),\"actiTIME 2020 Online\")]")).click();
		driver.get("https://www.amazon.in/");
		//group by index
		//driver.findElement(By.xpath("(//span[contains(text(),\"Watches\")])[1]")).click();
		)
	}

}
