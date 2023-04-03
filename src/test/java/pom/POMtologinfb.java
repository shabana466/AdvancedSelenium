package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMtologinfb {
//Declaration
	@FindBy(id="email") private WebElement usernameTF;
	@FindBy(id="pass") private WebElement passwordTF;
	@FindBy(name="login") private WebElement loginButton;
	@FindBy(linkText="Forgotten password?") private WebElement forgotpasswordlink;
	@FindBy(linkText="Create new account") private WebElement createNewAccountLink;
	@FindBy(linkText="Create a Page") private WebElement createPageLink;
	//Initialization

	public POMtologinfb(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public void setUserName(String  username) {
		usernameTF.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordTF.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	public void clickForgetpassword(String password){
		forgotpasswordlink.sendKeys(password);
	}
	public void clickCreateNewAccount() {
		createNewAccountLink.click();
		
	}
	public void clickCreatepage() {
		createPageLink.click();
		
	}
	
	
}
