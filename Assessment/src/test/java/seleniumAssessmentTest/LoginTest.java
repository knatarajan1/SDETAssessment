package seleniumAssessmentTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumAssessment.Utilities.SeleniumBase;
import seleniumAssessment.part2.pages.LoginPage;

public class LoginTest extends SeleniumBase{
	
	private String tableName= "OHRM_Login";
	
	@DataProvider(name="testData")
	public String[][] getData(){
		return getTestData(this.getClass().getSimpleName());
	}
	
	@Test(dataProvider = "testData",priority =1)
	public void loginTest(String testCase) {
		String userName = getData(tableName, testCase, "USERNAME");
		String passowrd = getData(tableName, testCase, "PASSWORD");;
		new LoginPage().verifLogin(userName, passowrd);
		softAssert.assertAll();
	}

	
	
}
