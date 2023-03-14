package com.org.ui.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTestRunner {
    protected WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public void setDriver(ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
//        options.addArguments("--window-size=1920,1080", "--no-sandbox", "'--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");


        driver = new ChromeDriver(options);
        context.setAttribute("myDriver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
