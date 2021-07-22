package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class AdminPage extends CommonFunctions {

	@FindBy(xpath="//h1[text()='System Users']")
	private WebElement adminDashBoard;
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAdminPage() {
		String actual = adminDashBoard.getText();
		softAssert.assertEquals(actual, "System Users");
	}
	
}
