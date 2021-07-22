package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class PIMPage extends CommonFunctions{

	@FindBy(xpath="//h1[text()='Employee Information']")
	private WebElement pimDashboardText;
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyPIMDashboard() {
		String actual = pimDashboardText.getText();
		softAssert.assertEquals(actual, "Employee Information");
	}
}
