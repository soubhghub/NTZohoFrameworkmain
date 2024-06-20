package pages;

import org.openqa.selenium.WebDriver;

public class BasePageActions {
    protected WebDriver driver;
    protected BasePageElements elements;

    public BasePageActions(WebDriver driver, BasePageElements elements) {
        this.driver = driver;
        this.elements = elements;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
