package seleniumAssessment.Utilities.CommonIUtilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext ;
import org.testng.ITestListener ;
import org.testng.ITestResult ;

import seleniumAssessment.Utilities.GlobalVaraiabales;	
public class TestListner extends CommonFunctions implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String fileName= screenShotPathPassed+result.getName()+".png";
		takeScreenShot(fileName);
		 		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String fileName= screenShotPathFailed+result.getName()+".png";
		takeScreenShot(fileName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
