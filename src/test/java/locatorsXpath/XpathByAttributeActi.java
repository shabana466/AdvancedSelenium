package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByAttributeActi {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@name=\"remember\"]")).click();
		driver.findElement(By.xpath("//a[@id=\"loginButton\"]")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
