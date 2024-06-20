package utils;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromedriver.path"));
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("firefoxdriver.path"));
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static void clearBrowserCache(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData"); // For Chrome
        // driver.get("about:preferences#privacy"); // For Firefox

        try {
            Thread.sleep(3000); // Allow time for the settings page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Specific implementation for clearing cache in Chrome using JavaScript
        if (driver instanceof ChromeDriver) {
            ChromeDriver chromeDriver = (ChromeDriver) driver;
            chromeDriver.executeScript(
                    "var callback = arguments[arguments.length - 1];" +
                    "chrome.browsingData.remove({" +
                    "\"since\": 0,\"origins\": [\"<all_urls>\"]}," +
                    "{\"appcache\": true,\"cache\": true,\"cookies\": true," +
                    "\"downloads\": true,\"fileSystems\": true,\"formData\": true," +
                    "\"history\": true,\"indexedDB\": true,\"localStorage\": true," +
                    "\"pluginData\": true,\"passwords\": true,\"webSQL\": true}, callback);"
            );
        }

        // Specific implementation for clearing cache in Firefox using JavaScript
        if (driver instanceof FirefoxDriver) {
            FirefoxDriver firefoxDriver = (FirefoxDriver) driver;
            firefoxDriver.executeScript(
                    "var callback = arguments[arguments.length - 1];" +
                    "browser.browsingData.remove({" +
                    "\"since\": 0,\"origins\": [\"<all_urls>\"]}," +
                    "{\"appcache\": true,\"cache\": true,\"cookies\": true," +
                    "\"downloads\": true,\"fileSystems\": true,\"formData\": true," +
                    "\"history\": true,\"indexedDB\": true,\"localStorage\": true," +
                    "\"pluginData\": true,\"passwords\": true,\"webSQL\": true}, callback);"
            );
        }

        driver.navigate().refresh(); // Refresh the browser
    }
}
