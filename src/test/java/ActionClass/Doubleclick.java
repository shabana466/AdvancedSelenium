package ActionClass;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Doubleclick {

	public static void main(String[] args) {

		ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://demoapp.skillrary.com/product.php?product=selenium-training");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
WebElement button = driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
Actions act=new Actions(driver);

act.contextClick(button).perform();//Right click menu


	}

}
