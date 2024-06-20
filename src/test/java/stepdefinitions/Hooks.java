package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BaseTest;
import utils.ExtentReportManager;

public class Hooks extends BaseTest {

    @Before
    public void setUp(Scenario scenario) {
        setupExtentReport();
        test = ExtentReportManager.createTest(scenario.getName());
        setupWebDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Test failed: " + scenario.getName());
        } else {
            test.pass("Test passed: " + scenario.getName());
        }
        tearDownWebDriver();
        tearDownExtentReport();
    }
}
