package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	//Declaration
	@FindBy(xpath ="//a[@class='hdrLink']")
	private WebElement pageHeader;
	@FindBy (xpath="//img[@title='Create Lead...']")
	private WebElement plusButton;
	//@FindBy (xpath="//table[@class='lvt small']//tr[last()]//td[3]")
	  @FindBy (xpath="//table[@class='lvt small']/descendant::tr[last()]/td[3]")
	  //doubt
	//@FindBy(xpath="//table[@class='lvt small']\"+\"/descendant::tr[last()]/td[3]")
	private WebElement newLeadLastName;

	//Initialization
		public LeadPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public String getPageHeaderText() {
			return pageHeader.getText();
		}
		public void clickPlusButton() {
			plusButton.click();
		}
		public String getNewLeadName() {
			return newLeadLastName.getText();
		}
	

}
