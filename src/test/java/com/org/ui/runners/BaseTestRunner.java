package com.org.ui.runners;

import com.ita.edu.speakua.utils.ConfigProperties;
import com.ita.edu.speakua.utils.TestNgListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestNgListener.class)
public class BaseTestRunner {
    protected WebDriver driver;
    protected static final ConfigProperties configProperties = new ConfigProperties();

    @BeforeSuite
    public void initDriver() {
//        configProperties = new ConfigProperties();
        WebDriverManager.chromedriver().setup();
    }

    public void setDriver(ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080", "--no-sandbox", "'--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        context.setAttribute("myDriver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(configProperties.getBaseWebUrl());
    }

    @AfterSuite
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
