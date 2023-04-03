package dropdownmenu;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectclass {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         WebElement courseElement =driver.findElement(By.id("course"));
          Select coursenamedropdown=new Select(courseElement);
          //for single selection we dont use collect to store elements if its double selection its shoud be use
//          List<WebElement> coursenamedropdowns = coursenamedropdown.getOptions();
//          for(  WebElement option:coursenamedropdowns) {
//         	  System.out.println(option.getText());
//           }
          coursenamedropdown.selectByIndex(1);
          Thread.sleep(3000);
          coursenamedropdown.selectByValue("net");
          Thread.sleep(3000);
         coursenamedropdown.selectByVisibleText("Javascript");
          Thread.sleep(3000);
      //String  selectedText  =coursenamedropdown.getFirstSelectedOption().getText();
      //System.out.println("selectedvisibletext:"+selectedText);
         // Thread.sleep(3000);
          
          
          
	}

}
