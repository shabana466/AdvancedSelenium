package pom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class POlogin2 {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		POMtologinfb login=new POMtologinfb(driver);
		login.setUserName("9900469093");
		login.setPassword("Kvreddy_93");
		login.clickLoginButton();
		Thread.sleep(2000);
		driver.quit();
}
}
