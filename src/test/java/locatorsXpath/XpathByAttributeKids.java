package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByAttributeKids {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@data-reactid=\"335\"]")).click();
		if(driver.getTitle().contains("Kids Clothing - Buy Kids Clothes, Dresses & Bottom wear Online in India"))
System.out.println("test pass");
		else
			System.out.println("test fail");
		driver.quit();
	}

}
