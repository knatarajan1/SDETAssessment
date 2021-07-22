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
public class TestListner extends GlobalVaraiabales implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		  TakesScreenshot screenShot = (TakesScreenshot)driver;       
          File source = screenShot.getScreenshotAs(OutputType.FILE);  
          File destination = new File(screenShotPathPassed+result.getName()+".png");
          try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		  TakesScreenshot screenShot = (TakesScreenshot)driver;       
          File source = screenShot.getScreenshotAs(OutputType.FILE);  
          File destination = new File(screenShotPathFailed+result.getName()+".png");
          try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
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
