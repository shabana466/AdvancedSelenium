
package pomImplementation;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generivUtilities.Autoconstantpath;
import generivUtilities.BaseClass;
@Listeners(generivUtilities.ListnerImplementation.class)
public class createAndDuplicateLeadTestBase extends BaseClass {
	@Test
	public void createAndDuplicateLeadTest() {
		SoftAssert soft=new SoftAssert();
		home.clickLeadsTab();
		soft.assertTrue(leads.getPageHeaderText().equals("Leads"));
		leads.clickPlusButton();
		soft.assertTrue(createLead.getPageHeaderText().equals("Creating New Lead"));
		Map<String,String> map=excel.readDataFromExcel("LeadsTestData","Create and Duplicate Lead");
		   String LastName = map.get("Last Name")+javautil.generateRandomNumber(100);
		   String company=map.get("Company")+javautil.generateRandomNumber(100);
		   //create new lead
		   createLead.setLastName(LastName);
		   createLead.setCompanyName(company);
		   createLead.clicksaveButton();
		   //verify pageHeaderText after created lead
		   soft.assertTrue(leadInfo.getPageHeaderText().contains(LastName));
		 //click on duplicate button after created lead
		   String newLastName = map.get("New Last Name")+javautil.generateRandomNumber(100);
		   leadInfo.clickDuplicateButton();
		   soft.assertTrue(duplicateLead.getPageHeaderText().contains("Duplicating"));
		   duplicateLead.setLastName(newLastName);
			  duplicateLead.clicksaveButton();
			  soft.assertTrue(leads.getNewLeadName().equals(newLastName));
			  if(leads.getNewLeadName().equals(newLastName)) {
					System.out.println("Lead added to data base");
					excel.writeToExcel("LeadsTestData", "Pass", "Create and Duplicate Lead", Autoconstantpath.Excel_PATH);
				}
				else {
					System.out.println("Lead not added to data base");
					excel.writeToExcel("LeadsTestData", "Fail", "Create and Duplicate Lead", Autoconstantpath.Excel_PATH);
				}
			  soft.assertAll();
			  
		   
		
	}

}

