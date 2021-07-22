package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class DashboardPage extends CommonFunctions {
	@FindBy(xpath = "//h1[text()='Dashboard']")
	private WebElement dashboardText;
	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement adminLink;
	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement pimLink;
	@FindBy(id = "menu_leave_viewLeaveModule")
	private WebElement leaveDashboardLink;
	@FindBy(id="menu_directory_viewDirectory")
	private WebElement directoryLink;
	@FindBy(id = "menu_maintenance_purgeEmployee")
	private WebElement maintainanceLink;
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void dashBoardPresent() {

		String actual = dashboardText.getText();
		softAssert.assertEquals(actual, "Dashboard");

	}
	
	public void navigateTo(Pages pageName) {
	
		switch (pageName) {
		case AdminPage:
			clickElement(adminLink);
			new AdminPage().verifyAdminPage();
			break;
		case PIMPage:
			clickElement(pimLink);
			new PIMPage().verifyPIMDashboard();
			break;
		case LeaveDashboardPage:
			clickElement(leaveDashboardLink);
			new LeaveDashboardPage().verifyLeaveDashBoard();
			break;
		case DirectoryPage:
			clickElement(directoryLink);
			new DirectoryPage().verifyDirectoryDashboard();
			break;
		case MaintainancePage:
			clickElement(maintainanceLink);
			new MaintainancePage().verifyMaintainanceDashboard();
			break;
		default:
			break;
		}
	}
}
