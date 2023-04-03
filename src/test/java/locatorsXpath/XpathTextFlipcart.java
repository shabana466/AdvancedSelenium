package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTextFlipcart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Filpkart.com/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//span[text()='Become a Seller'])[1]")).click();
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		if(driver.getTitle().contains("Shopping Cart | Flipkart.com"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		driver.close();

	}

}
