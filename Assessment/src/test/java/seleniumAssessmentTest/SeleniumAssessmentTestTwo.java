package seleniumAssessmentTest;

import org.testng.annotations.Test;

import seleniumAssessment.Utilities.SeleniumBase;
import seleniumAssessment.part2.pages.DashboardPage;
import seleniumAssessment.part2.pages.LoginPage;
import seleniumAssessment.part2.pages.PIMPage;
import seleniumAssessment.part2.pages.Pages;

public class SeleniumAssessmentTestTwo extends SeleniumBase{
	private String testData = "TC1";
	private String loginTableName = "OHRM_Login";
	private String pimTableName="OHRM_PIM";
	@Test
	public void employeeTestSearch() {
		new LoginPage().verifLogin(getData(loginTableName, testData, "USERNAME"), getData(loginTableName, testData, "PASSWORD"));
		new DashboardPage().navigateTo(Pages.PIMPage);
		new PIMPage().validateEmployeeSearch(getData(pimTableName, testData, "EMPLOYEE_FIRST_NAME"), getData(pimTableName, testData, "EMPLOYEE_LAST_NAME"));	
	}
}
