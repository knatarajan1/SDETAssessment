package seleniumAssessment.part2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumAssessment.Utilities.CommonIUtilities.CommonFunctions;

public class DirectoryPage extends CommonFunctions {
	@FindBy(xpath="//h1[text()='Search Directory']")
	private WebElement directoryDashboardText;
	public DirectoryPage() {
		PageFactory.initElements(driver, this);
	}
	public void verifyDirectoryDashboard() {
		String actual = directoryDashboardText.getText();
		softAssert.assertEquals(actual, "Search Directory");
	}
}
