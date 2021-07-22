package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;
import seleniumAssessment.Utilities.CommonIUtilities.TestListner;
@Listeners(TestListner.class)
public class LoginPage extends CommonFunctions{

	
	@FindBy(xpath = "//input[@id='txtUsername']")
	private WebElement userName;
	@FindBy(css = "input#txtPassword")
	private WebElement Password;
	@FindBy(css = "input#btnLogin")
	private WebElement loginButton;
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	private LoginPage setUserName(String userName) {
		setValue(this.userName, userName);
		return this;
	}
	private LoginPage setPassword(String password) {
		setValue(this.Password, password);
		return this;
	}
	private DashboardPage clickLoginButton() {
		clickElement(this.loginButton);
		return new DashboardPage();
	}
	/**
	 * Validate Login
	 * @param userName
	 * @param passowrd
	 * @param softAssert
	 */
	public  void verifLogin(String userName, String passowrd, SoftAssert softAssert) {
							setUserName(userName).
							setPassword(passowrd).
							clickLoginButton().
							dashBoardPresent();
		}
}
