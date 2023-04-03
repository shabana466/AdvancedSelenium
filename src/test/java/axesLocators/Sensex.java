package axesLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sensex {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/stocksmarketsindia/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href=\"/indian-indices/nifty-50-9.html\"]/parent::td/parent::tr/child::td[2]"));
		//driver.findElement(By.xpath("//div[@class=\"header-logo-container\"]/../div[2]/div/div[@class=\"sc-iveFHk wNxAQ\""));

	}

}
