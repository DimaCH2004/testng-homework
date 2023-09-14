import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;
    private static final int retryLimit = 4;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testThatFailsFiveTimes() {
        Assert.fail("Failing the test intentionally");
    }
}
