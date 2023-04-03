package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingLeadPage {
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name="lastname")
	private WebElement lastTF;
	@FindBy(xpath="(//input[normalize-space(@value)='Save'])[1]")//doubt
	private WebElement saveButton;
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement leadslink;
	//Initialization
			public DuplicatingLeadPage(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}
			//Utilization
			public String getPageHeaderText() {
				return pageHeader.getText().trim();
			}
			public void setLastName(String leadname) {
				lastTF.clear();
		        lastTF.sendKeys(leadname);
			}
			public void clicksaveButton() {
				saveButton.click();

	}
			public void clickleads() {
				leadslink.click();
			}
}
