package seleniumAssessmentTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import seleniumAssessment.Utilities.SeleniumBase;
import seleniumAssessment.Utilities.CommonIUtilities.RetryListener;
import seleniumAssessment.Utilities.CommonIUtilities.TestListner;
import seleniumAssessment.part2.pages.DashboardPage;
import seleniumAssessment.part2.pages.LoginPage;
import seleniumAssessment.part2.pages.MaintainancePage;
import seleniumAssessment.part2.pages.Pages;

@Listeners(TestListner.class)
public class SeleniumAssessmentTest extends SeleniumBase {
/*
		6- Launch a browser in @Beforesuite annotation and open url . url - https://opensource-demo.orangehrmlive.com/
		7- Login to application again in @Test method, set priority 1 of the same method After logging
		8- Write Test method and page title for different menus- in order(Admin, PIM, Leave Dashboard, Directory and Maintenance)
 		9- Write a method (avoid using Test annotation) to minimize the window.
		10- Read Dashboard heading using [driver.findelement(by.xpath()).gettext()].
		11- Implement ITestListener for above scenario where full-page screenshot needs to be capture where ever test is pass or failed. Hint – Please use Shutterbug class
		12- Implement Retry analyzer – retry 3 times only for the above scenario.
 */
	private String testData = "TC1";
	private String loginTableName = "OHRM_Login";

	@Test(priority=1)
	public void login() {
		String userName = getData(loginTableName, testData, "USERNAME");
		String passowrd = getData(loginTableName, testData, "PASSWORD");
		new LoginPage().verifLogin(userName, passowrd);
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void admin() {
		new DashboardPage().navigateTo(Pages.AdminPage);
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void pim() {
		new DashboardPage().navigateTo(Pages.PIMPage);
		softAssert.assertAll();
	}
	@Test(priority=4)
	public void leaveDashBoard() {
		new DashboardPage().navigateTo(Pages.LeaveDashboardPage);
		softAssert.assertAll();
	}
	
	@Test(priority=5)
	public void dierectory() {
		new DashboardPage().navigateTo(Pages.DirectoryPage);
		softAssert.assertAll();
	}
	@Test(priority=6)
	public void maintainance() {
		new DashboardPage().navigateTo(Pages.MaintainancePage);
		softAssert.assertAll();
		minimizeWindow();
	}
	@Test(retryAnalyzer = RetryListener.class,priority =7)
	public void maintainanceFailureMethod() {
		new MaintainancePage().failureMethod();
		softAssert.assertAll();
	}
}
