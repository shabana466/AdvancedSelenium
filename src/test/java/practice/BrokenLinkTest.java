package practice;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinkTest {
	@Test
	public void brokenLinkTest() throws IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//to fetch all links from webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.err.println(links.size());
		//to get each link from webpage
		for(WebElement link:links) {
			String linkURL = link.getAttribute("href");
			if(linkURL==null||linkURL.isBlank()||(!linkURL.contains("http)"))) {
           System.out.println(linkURL +"->brokenlink");
           continue;
			}
		//TO CONVERT FROM LINK TO ACTUAL URL
			URL  url=new URL(linkURL);
			//to connect server
			HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
			httpURLConnection.connect();
			httpURLConnection .setConnectTimeout(5000);
			if(httpURLConnection.getResponseCode()!= 200) 
				System.err.println(linkURL+"->"+httpURLConnection.getResponseCode()+"->"+httpURLConnection.getResponseMessage());
			httpURLConnection.disconnect();
			}
	}
}

	


