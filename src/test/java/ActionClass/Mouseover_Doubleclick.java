package ActionClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouseover_Doubleclick {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://demoapp.skillrary.com/");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

   WebElement course = driver.findElement(By.id("course"));
   //move to element
   Actions a=new Actions(driver);
   a.moveToElement(course).perform();
   driver.findElement(By.xpath("//span[@class=\"wrappers\"]//a[text()=\"Selenium Training\"]")).click();
   
  int quatityAfter = Integer.parseInt(driver.findElement(By.id("quantity")).getAttribute("value"));
        
        WebElement pulsbutton = driver.findElement(By.xpath("//i[@class=\"fa fa-plus\"]"));
   
   a.doubleClick(pulsbutton).perform();
   int quatitybefore = Integer.parseInt(driver.findElement(By.id("quantity")).getAttribute("value"));
   if(quatityAfter==quatitybefore+1) {
   System.out.println("pass");

	}
	else {
		System.out.println("fail");
}
   driver.quit();
}
}



