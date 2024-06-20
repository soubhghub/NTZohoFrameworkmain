package pages;

import org.openqa.selenium.WebDriver;

public class LoginPageActions extends BasePageActions {
    private static LoginPageActions instance;
    private LoginPageElements loginPageElements;

    private LoginPageActions(WebDriver driver) {
        super(driver, new LoginPageElements(driver));
        this.loginPageElements = (LoginPageElements) this.elements;
    }

    public static LoginPageActions getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new LoginPageActions(driver);
        }
        return instance;
    }

    public void enterEmail(String email) {
        loginPageElements.emailField.sendKeys(email);
    }

    public void clickNext() {
        loginPageElements.nextButton.click();
    }

    public void enterPassword(String password) {
        loginPageElements.passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginPageElements.loginButton.click();
    }
}
