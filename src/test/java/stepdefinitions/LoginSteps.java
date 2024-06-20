package stepdefinitions;

import config.ConfigReader;
import dataProvider.ExcelDataProvider;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPageActions;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.util.List;

public class LoginSteps extends BaseTest {
    WebDriver driver;
    LoginPageActions loginPageActions;
    ExcelDataProvider excelDataProvider;

    @Given("I am on the Zoho login page")
    public void i_am_on_the_zoho_login_page() {
        setupWebDriver();
        driver = BaseTest.driver;
        loginPageActions = LoginPageActions.getInstance(driver);
        test = ExtentReportManager.createTest("Login Test");
        test.info("Navigated to Zoho login page");
    }

    @When("I clear the browser cache")
    public void i_clear_the_browser_cache() {
        clearCache();
        test.info("Cleared the browser cache");
    }

    @When("I enter login details from excel")
    public void i_enter_login_details_from_excel() {
        excelDataProvider = new ExcelDataProvider(ConfigReader.getProperty("excel.path"));
        List<String> userData = excelDataProvider.getRowData("LoginData", 1); // Using LoginData sheet and second row
        loginPageActions.enterEmail(userData.get(0));
        loginPageActions.clickNext();
        loginPageActions.enterPassword(userData.get(1));
        test.info("Entered login details from Excel");
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        loginPageActions.clickLogin();
        test.info("Clicked the Login button");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Add assertions to verify successful login
        test.pass("Login was successful");
        tearDownWebDriver();
        tearDownExtentReport();
    }
}
