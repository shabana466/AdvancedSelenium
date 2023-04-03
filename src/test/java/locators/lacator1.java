package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class lacator1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/LENOVO/Documents/jsonfile/lacatordemo1.html");
     WebElement link =driver.findElement(By.id("f"));
     link.click();
     driver.navigate().back();
     driver.findElement(By.name("forget"));
     driver.navigate().back();
     driver.findElement(By.className("pass"));
     driver.navigate().back();
     Thread.sleep(2000);
     driver.findElement(By.tagName("a"));
     driver.navigate().back();
     Thread.sleep(2000);
     driver.findElement(By.linkText("Forgot Password??")).click();
     driver.navigate().back();
     Thread.sleep(2000);
     driver.findElement(By.partialLinkText("Forgot")).click();
     Thread.sleep(2000);
     
     
     
     
       
	}

}
