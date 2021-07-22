package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class LeaveDashboardPage extends CommonFunctions {

	@FindBy(xpath="//h1[text()='Leave List']")
	private WebElement leaveDashboardText;
	public LeaveDashboardPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyLeaveDashBoard() {
		String actual = leaveDashboardText.getText();
		softAssert.assertEquals(actual, "Leave List");
	}
}
