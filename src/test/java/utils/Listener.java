package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Listener implements IRetryAnalyzer {
    int count=0;
    int maxTry=Integer.parseInt(ConfigReader.getProperty("retry-failed-tests"));

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (ConfigReader.getProperty("retry").equalsIgnoreCase("true")
                && iTestResult.getStatus() == ITestResult.FAILURE){
                if(count<maxTry){
                    count++;
                    //LoggerUtil.info("Retrying"+iTestResult.getTestName() + " "+count+" time");
                    return true;
                }
        }
        return false;
    }
}
