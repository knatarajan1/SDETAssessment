package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class DashboardPage extends CommonFunctions {
	@FindBy(xpath = "//h1[text()='Dashboard']")
	private WebElement dashboardText;
	@FindBy(xpath = "//a[@id='menu_admin_viewAdminModule']")
	private WebElement adminLink;
	@FindBy(css="a#menu_leave_viewLeaveModule")
	private WebElement leaveDashboardLink;
	@FindBy(id="menu_directory_viewDirectory")
	private WebElement directoryLink;
	//Step 13 
	@FindBy(css = "a#menu_pim_viewPimModule")
	private WebElement pimLink;
	@FindBy(css = "a#menu_maintenance_purgeEmployee")
	private WebElement maintainanceLink;
	@FindBy(css = "a#menu_time_viewTimeModule")
	private WebElement timeLink ;
	@FindBy(css = "img[src*='ApplyLeave.png']")
	private WebElement applyLeave ;
	@FindBy(css = "img[src*='MyTimesheet.png']")
	private WebElement timeSheet ;
	@FindBy(css = "div#div_graph_display_emp_distribution")
	private WebElement employeeDistribution ;
	//Step 14
	@FindBy(xpath="//input[@id='MP_link']")
	private WebElement marketPlace;
	@FindBy(xpath = "//a[@id='welcome']")
	private WebElement welcomeAdmin;
	@FindBy(xpath="//span[text()='Leave List']//preceding::a[1]")
	private WebElement leaveList;
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
