package IndependentAndDependent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MeeshoTshirt {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.meesho.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder=\"Try Saree, Kurti or Search by Product Code\"]"));
		//driver.findElement(By.xpath("//div[@class=\"header-logo-container\"]/../div[2]/div/div[@class=\"sc-iveFHk wNxAQ\""));
		Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//p[text()=\"tshirt\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		//price
		driver.findElement(By.xpath("//p[text()=\"Comfy Latest Men Tshirts\"]/../div/h5[@class=\"sc-dkrFOg iIAyXW\"]")).click();
		//Free Delivery
		driver.findElement(By.xpath("//div[@class=\"plp-card-details-container\"]/../div/div[4]/span[@class=\"jm-fc-primary-grey-100\"]")).click();
		//star rating  
		driver.findElement(By.xpath("//p[text()=\"Comfy Latest Men Tshirts\"]/../../../div[3]/div/span[@class=\"sc-kgTSHT jBtJw\"]")).click();
		//reviews
		driver.close();

	}

}
