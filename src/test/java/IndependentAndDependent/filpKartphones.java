package IndependentAndDependent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class filpKartphones {
	public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.Filpkart.com/");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("tv smart tv");
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(text(),\"Mi 5A 80 cm (32 inch) \")]/../../div[2]/div/div/div[@class=\"_30jeq3 _1_WHN1\"]")).click();
	driver.findElement(By.xpath("//div[contains(text(),\"2023 Edition with Voice Assist\")]/../../div[2]/div/div/div[@class=\"_30jeq3 _1_WHN1\"]")).click();

	driver.findElement(By.xpath("//div[text()=\"acer I Series 80 cm (32 inch) HD Ready LED Smart Android TV with Android 11, 1.5GB RAM (2022 Model)\"]/../../div[2]/div/div/div[@class=\"_30jeq3 _1_WHN1\"]")).click();
//starrating
	driver.findElement(By.xpath("//div[contains(text(),\"by TCL F53 100 cm (40 inch)\")]/../div[2]/span[@class=\"_1lRcqv\"")).click();
	//bank offer
	driver.findElement(By.xpath("//div[contains(text(),\"Mi 5A 80 cm (32 inch) \")]/../../div[2]/div[4]/div/div[@class=\"_2Tpdn3 _18hQoS\"]")).click();

	driver.close();

}
}
