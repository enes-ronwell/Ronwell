package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        tags = "",
        glue = {"stepDefinations", "util"},
        features = {"src/test/java/features"},
        plugin = {
                "summary",
                "pretty",
                "html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class runnerCucumber extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeTest()
    public void beforeTest() {
    }

    @BeforeClass
    public void beforeClass() {
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @BeforeGroups
    public void beforeGroup() {
    }

    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
    }

    @AfterTest
    public void afterTest() {
    }

    @AfterSuite
    public void afterSuite() {
    }

    @AfterGroups
    public void afterGroup() {
    }




}
