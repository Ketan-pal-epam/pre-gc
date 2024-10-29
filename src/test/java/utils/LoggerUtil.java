package Utils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




public class LoggerUtil implements ITestListener {
    private static final Logger LOG = LogManager.getLogger(LoggerUtil.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("Starting test: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("Test passed: {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.error("Test failed: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.warn("Test skipped: {}", result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("Finished all tests in context: {}", context.getName());
    }
}