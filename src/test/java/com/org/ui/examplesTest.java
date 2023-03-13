package com.org.ui;


import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class examplesTest extends BaseTestRunner {

    @BeforeMethod
    public void setUp(ITestContext context) {
        setDriver(context);
    }

    @Test
    public void isOpenHomePage() {
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Ініціатива')]"));
        String text = element.getText();

        Assert.assertEquals(text, "Ініціатива “Навчай українською”");
        Assert.assertEquals(driver.getTitle(), "Навчай українською");
    }

    @Test
    public void loginSuccessTest() {
        boolean isContainExit = new HomePage(driver).openGuestProfileMenu().openLoginModel().enterEmail(configProperties.getAdminEmail()).enterPassword(configProperties.getAdminPassword()).clickLogin().openGuestProfileMenu().isContain("Вийти");

        Assert.assertTrue(isContainExit);
    }

    @Test
    public void ClubPageSuccessTest() {
        String actualTitle = new HomePage(driver).clickClub().getCards().get(2).getTitle();

        Assert.assertEquals(actualTitle, "IT освіта: курси \"ГРАНД\"");
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
