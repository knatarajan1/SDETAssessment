package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class MaintainancePage extends CommonFunctions {
	@FindBy(xpath="//h1[text()='Purge Employee Records']")
	private WebElement maintainanceDashboardText;
	public MaintainancePage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyMaintainanceDashboard() {
		String actual = maintainanceDashboardText.getText();
		softAssert.assertEquals(actual, "Purge Employee Records");
	}
	public void failureMethod() {
		boolean actual = validateVisibility(maintainanceDashboardText);
		softAssert.assertEquals(actual, false);
	}
}
