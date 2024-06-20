package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageElements extends BasePageElements {

    public SignUpPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "namefield")
    public WebElement firstNameField;

    @FindBy(id = "emailfield")
    public WebElement emailField;

    @FindBy(id = "passwordfield")
    public WebElement passwordField;

    @FindBy(id = "signup-termservice")
    public WebElement termsCheckbox;

    @FindBy(id = "signupbtn")
    public WebElement signUpButton;
}
