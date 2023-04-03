package locators;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		//self axes -select the current node
		//String text = driver.findElement(By.xpath("//a[contains(text(),'PB Fintech')]/self::a")).getText();
		//System.out.println(text);
		//parent-selects the parent of current node
		//String text = driver.findElement(By.xpath("//a[contains(text(),'PB Fintech')]/parent::td")).getText();
		//System.out.println(text);
		//child=selects all children of te current node(one or many)
		 List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(),'PB Fintech')]/ancestor::tr/child::td"));
		System.out.println("no of childs elements:"+childs.size());
		//ancestor-selects all ancestors(parents,grandparent,etc
		
		  // String text = driver.findElement(By.xpath("//a[contains(text(),'PB Fintech')]/ancestor::tr")).getText();
		  // System.out.println(text);
		
		   //descendant-select all descendents(childrens,grandchildrens,etc of the current node
		   List<WebElement>  descendants = driver.findElements(By.xpath("//a[contains(text(),\"PB Fintech\")]/ancestor::tr/descendant::*"));
System.out.println(descendants.size());

//followning-selects everything in the document after the closing tag
//a[contains(text(),"PB Fintech")]/ancestor::tr/following-sibling::tr
List<WebElement>  followingnodes = driver.findElements(By.xpath("//a[contains(text(),\"PB Fintech\")]/ancestor::tr/following-sibling::tr"));
System.out.println(followingnodes.size());
//following_sibling-select all siblings after the current node

List<WebElement>  followingsibling = driver.findElements(By.xpath("//a[contains(text(),\"PB Fintech\")]/ancestor::tr/following-sibling::tr"));
System.out.println(followingsibling.size());
//preceding-selects all nodes that appear the current node in the document
List<WebElement> precedingnodes = driver.findElements(By.xpath("//a[contains(text(),\"PB Fintech\")]/ancestor::tr/preceding::tr"));
System.out.println("no of the preseding nodes:"+precedingnodes.size());
//preceding-sibling
List<WebElement> precedingsiblings = driver.findElements(By.xpath("//a[contains(text(),\"PB Fintech\")]/ancestor::tr/preceding::tr"));
System.out.println("no of the precedingsiblings:"+precedingsiblings.size());


	}

}
