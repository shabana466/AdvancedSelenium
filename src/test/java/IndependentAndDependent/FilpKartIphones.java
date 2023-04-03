package IndependentAndDependent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FilpKartIphones {
	public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://practice.automationtesting.in/product/thinking-in-html/");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//h3[text()=\"HTML5 Forms\"]/../../a[text()=\"Read more\"]")).click();
	driver.close();
	

}
}
