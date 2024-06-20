package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends BasePageElements {

    public LoginPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_id")
    public WebElement emailField;

    @FindBy(id = "nextbtn")
    public WebElement nextButton;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "nextbtn")
    public WebElement loginButton;
}
