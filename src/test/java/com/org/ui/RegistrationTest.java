package com.org.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTest extends BaseTestRunner {
    @BeforeMethod
    public void setUp(ITestContext context) {
        setDriver(context);
    }
    @Description("Registration data is remembered after exit")
    @Test
    public void RegistrationDataRemembered() {

        RegisterModal dataSaved= new HomePage(driver)
                .openGuestProfileMenu()
                .openRegistrationModel()
                .enterLastName("Войтович")
                .enterFirstName("Світлана")
                .enterPhone("671234567")
                .enterEmail("svitlanawhite@gmail.com")
                .enterPassword("12345678")
                .enterPasswordConfirm("12345678")
                .cancelRegistration()
                .openGuestProfileMenu()
                .openRegistrationModel();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dataSaved.getLastNameInput().getText(),"Войтович","Not empty last name field");
        softAssert.assertEquals(dataSaved.getFirstNameInput().getText(),"Світлана","Not empty first name field");
        softAssert.assertEquals(dataSaved.getPhoneInput().getText(),"671234567","Not empty phone field");
        softAssert.assertEquals(dataSaved.getEmailInput().getText(),"svitlanawhite@gmail.com","Not empty email field");
        softAssert.assertEquals(dataSaved.getPasswordInput().getText(),"12345678","Not empty password field");
        softAssert.assertEquals(dataSaved.getPasswordConfirmInput().getText(),"12345678","Not empty password confirm field");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

