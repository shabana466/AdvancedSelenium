package IndependentAndDependent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amzonwatch {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("iphones");
		driver.findElement(By.xpath("//input[@value=\"Go\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=\"Apple iPhone 12 (128GB) - Purple\"]/../../../../div[3]/div/div/div/div/a/span[@class=\"a-price\"]")).click();
//doubt if independent element is duplicates wt we can do
		//driver.findElement(By.xpath(" //span[text()=\"Apple iPhone 13 (128GB) - Midnight\"]")).click();
		//star rating
		driver.findElement(By.xpath(" //span[text()=\"Apple iPhone 14 (128 GB) - (Product) RED\"]/../../../../div[2]/div/span/span[@class=\"a-declarative\"]")).click();
		driver.findElement(By.xpath("(//img[@class=\"_bXVsd_image_1pfbQ\"])[1]/../../../../div[2]//span[@class=\"_bXVsd_image_1pfbQ\"]")).click();
		//driver.findElement(By.xpath(" //span[text()=\"Apple iPhone 13 (128GB) - Midnight\"]")).click();
	}

}
