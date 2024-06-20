package pages;

import org.openqa.selenium.WebDriver;

public class SignUpPageActions extends BasePageActions {
    private static SignUpPageActions instance;
    private SignUpPageElements signUpPageElements;

    private SignUpPageActions(WebDriver driver) {
        super(driver, new SignUpPageElements(driver));
        this.signUpPageElements = (SignUpPageElements) this.elements;
    }

    public static SignUpPageActions getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new SignUpPageActions(driver);
        }
        return instance;
    }

    public void enterFirstName(String firstName) {
        signUpPageElements.firstNameField.sendKeys(firstName);
    }

    public void enterEmail(String email) {
        signUpPageElements.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        signUpPageElements.passwordField.sendKeys(password);
    }

    public void acceptTerms() {
        signUpPageElements.termsCheckbox.click();
    }

    public void clickSignUp() {
        signUpPageElements.signUpButton.click();
    }
}
