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
		//doubt//price
		driver.findElement(By.xpath("//a[@href=\"/indian-indices/nifty-50-9.html\"]/parent::td/parent::tr/child::td[2]")).click();
	//change
		driver.findElement(By.xpath("//a[contains(text(),\"Axis Bank\")]/parent::td/parent::tr/child::td[3]"));
//current
		driver.findElement(By.xpath("//a[contains(text(),\"ICICI Bank\")]/parent::td/parent::tr/child::td[4]")).click();
		//market
		driver.findElement(By.xpath("//ul[@class=\"clearfix main_nav\"]/child::li/child::a[@title=\"News\"]")).click();
		driver.findElement(By.xpath("(//span[@class=\"robo_medium\"])[1]/parent::td/parent::tr/child::td[@class=\"tbl_greentxt\"]")).click();


		//doubt stockMarket
		driver.findElement(By.xpath("(//section[@class=\"otherstock\"])[1]/child::div/child::div/child::div[text()=\"Stock Action\"]")).click();
	}
	
	
	

}
