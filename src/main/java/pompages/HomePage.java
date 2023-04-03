package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generivUtilities.Webdriverutility;

public class HomePage {
	
	//Declaration
	@FindBy(xpath ="//a[@class='hdrLink']")
	private WebElement pageHeader;
	@FindBy(xpath ="//a[text()='Leads']")
	private WebElement LeadsTab;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	
	
	//Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public String getPageHeaderText() {
			return pageHeader.getText();
		}
		public void clickLeadsTab() {
			LeadsTab.click();
		}
		public void SignOutVtiger(Webdriverutility web) {
			web.mouseHover(adminIcon);
			signoutLink.click();
		}
	

}
