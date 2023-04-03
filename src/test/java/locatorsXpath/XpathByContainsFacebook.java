package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByContainsFacebook {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//a[contains(text(),\"Voting \")]")).click();
		driver.findElement(By.xpath("//h2[contains(text(),\"helps \")]")).click();
		
		driver.findElement(By.xpath("//a[contains(@title,\"Read\")]")).click();
		driver.findElement(By.xpath("//a[contains(@title,\"Explore\")]")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
