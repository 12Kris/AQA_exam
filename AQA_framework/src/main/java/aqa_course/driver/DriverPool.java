package aqa_course.driver;

import aqa_course.util.PropertyUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverPool {
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static void main(String[] args) {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com");
        quitDriver();
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = PropertyUtil.getProperty("browser");
            System.out.println("Browser: " + browser);
            WebDriver driver = null;

            switch (browser.toLowerCase()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                }
                case "safari": {
                    driver = new SafariDriver();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            }

            driverPool.set(driver);
        }
        return driverPool.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverPool.get();
        if (driver != null) {
            driver.quit();
            driverPool.remove();
        }
    }
}

