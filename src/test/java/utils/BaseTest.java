package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static WebDriver driver;

    public void setupExtentReport() {
        extent = ExtentReportManager.createInstance();
    }

    public void tearDownExtentReport() {
        ExtentReportManager.flush();
    }

    public void setupWebDriver() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.getDriver(browser);
        driver.get(ConfigReader.getProperty("app.url"));
    }

    public void clearCache() {
        BrowserFactory.clearBrowserCache(driver);
    }

    public void tearDownWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
