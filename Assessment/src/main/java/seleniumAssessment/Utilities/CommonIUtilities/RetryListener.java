package seleniumAssessment.Utilities.CommonIUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{
	 int counter = 0;
	 int retryLimit = 3;
	 boolean retry = false;
	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit)
		 {
		 counter++;
		 retry =  true;
		 }
		else
		 retry = false;
		 return retry;
	}

}
