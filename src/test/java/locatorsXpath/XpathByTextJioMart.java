package locatorsXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByTextJioMart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jiomart.com/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Groceries']")).click();
        driver.findElement(By.xpath("//a[text()='Fashion']")).click();
        driver.findElement(By.xpath("//a[@id=\"nav_link_5\"]")).click();
        if(driver.getTitle().contains("Beauty - JioMart"))
        	System.out.println("Test pass");
        else
        	System.out.println("Test fail");
        driver.close();
        

	}

}
