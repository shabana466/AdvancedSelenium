package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByTextMeesho {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.meesho.com/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Women Western']")).click();
        driver.findElement(By.xpath("//span[text()='Bags & Footwear']")).click();
        driver.findElement(By.xpath("//span[text()='Become a Supplier']")).click();
        if(driver.getTitle().contains("Meesho Supplier: Sell online on Meesho at 0% commission"))
        System.out.println("Test pass");
        else
        	System.out.println("Test fail");
        driver.close();

	}

}
