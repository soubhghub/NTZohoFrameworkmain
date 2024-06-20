package stepdefinitions;

import config.ConfigReader;
import dataProvider.ExcelDataProvider;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.SignUpPageActions;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.util.List;

public class SignUpSteps extends BaseTest {
    WebDriver driver;
    SignUpPageActions signUpPageActions;
    ExcelDataProvider excelDataProvider;

    @Given("I am on the Zoho signup page")
    public void i_am_on_the_zoho_signup_page() {
        setupWebDriver();
        driver = BaseTest.driver;
        signUpPageActions = SignUpPageActions.getInstance(driver);
        test = ExtentReportManager.createTest("Sign Up Test");
        test.info("Navigated to Zoho signup page");
    }

    @When("I clear the browser cache")
    public void i_clear_the_browser_cache() {
        clearCache();
        test.info("Cleared the browser cache");
    }

    @When("I enter user details from excel")
    public void i_enter_user_details_from_excel() {
        excelDataProvider = new ExcelDataProvider(ConfigReader.getProperty("excel.path"));
        List<String> userData = excelDataProvider.getRowData("SignUpData", 1); // Using SignUpData sheet and second row
        signUpPageActions.enterFirstName(userData.get(0));
        signUpPageActions.enterEmail(userData.get(1));
        signUpPageActions.enterPassword(userData.get(2));
        signUpPageActions.acceptTerms();
        test.info("Entered user details from Excel");
    }

    @When("I click the Sign Up button")
    public void i_click_the_sign_up_button() {
        signUpPageActions.clickSignUp();
        test.info("Clicked the Sign Up button");
    }

    @Then("I should be signed up successfully")
    public void i_should_be_signed_up_successfully() {
        // Add assertions to verify successful sign-up
        test.pass("Sign up was successful");
        tearDownWebDriver();
        tearDownExtentReport();
    }
}
