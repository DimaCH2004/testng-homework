import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class ConfigTests {
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.screenshots = true;
    }
    @BeforeClass(alwaysRun = true)
    public void setBaseUrl(ITestContext context) {
        String className = context.getCurrentXmlTest().getXmlClasses().get(0).getName();

        if ("CheckboxTests".equals(className)) {
            Configuration.baseUrl = "http://the-internet.herokuapp.com/checkboxes";
            Configuration.reportsFolder = "CheckboxFailedTests";
        } else if ("RadioButtonTests".equals(className)) {
            Configuration.baseUrl = "https://demoqa.com/radio-button";
            Configuration.reportsFolder = "RadioButtonFailedTests";
        }
    }
    @BeforeMethod
    public void navigate() {
        open(Configuration.baseUrl);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        Selenide.screenshot(methodName + "-failed");
        closeWebDriver();
    }
}
