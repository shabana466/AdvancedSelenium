package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDealXpathAttribute {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id=\"inputValEnter\"]")).sendKeys("Headphones");
		driver.findElement(By.xpath("//i[@class=\"sd-icon sd-icon-search-under-catagory lfloat\"]")).click();
		//its displays multiples which title i will select doubt
         if(driver.getTitle().contains("Snapdeal.com - Online shopping India- Discounts - shop Online Perfumes, Watches, sunglasses etc"))
        	 System.out.println("pass test");
         else
        	 System.out.println("fail test");
         driver.close();
	}

}
