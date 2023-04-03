package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {
	//Declaration
	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name="lastname")
	private WebElement lastTF;
	@FindBy(name="company")
	private WebElement companyTF;
	@FindBy(xpath="(//input[normalize-space(@value)='Save'])[1]")//doubt
	private WebElement saveButton;
	//Initialization
			public CreateNewLeadPage(WebDriver driver) {
				PageFactory.initElements(driver,this);
			}
			//Utilization
			public String getPageHeaderText() {
				return pageHeader.getText().trim();
			}
			public void setLastName(String leadname) {
		        lastTF.sendKeys(leadname);
			}
	
			public void setCompanyName(String companyname) {
				companyTF.sendKeys(companyname);
			}
			public void clicksaveButton() {
			saveButton.click();

}
}
