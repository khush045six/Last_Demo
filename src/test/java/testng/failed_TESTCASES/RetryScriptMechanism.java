package testng.failed_TESTCASES;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryScriptMechanism implements IRetryAnalyzer {
    public int count = 0;
    public static final int RETRY_LIMIT = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count < RETRY_LIMIT){
            count++;
            return true;
        }
        return false;
    }
}
