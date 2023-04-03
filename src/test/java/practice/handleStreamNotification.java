package practice;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class handleStreamNotification {
   @Test
   public void mediaStreamNotification() throws InterruptedException {
   HashMap<String,Integer> contentSettings=new HashMap<>();
   contentSettings.put("media_stream", 1);
   HashMap<String,Object> profile=new HashMap<>();
   profile.put("managed_default_content_setting,", contentSettings);
   HashMap<String,Object> preference=new HashMap<>();
   preference.put("profile", profile);
   ChromeOptions options=new ChromeOptions();
   WebDriver driver=new ChromeDriver(options);
   
   driver.get("https://webcamtests.com/");
   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   driver.findElement(By.id("webcam-launcher")).click();
   Thread.sleep(5000);
   driver.quit();
   
		   }
}
