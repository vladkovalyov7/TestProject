package com.org.ui;

import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModal;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class ChangePasswordNegativeTests extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin();
    }
    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }


    @Test
    @Description("Test if warning message 'Будь ласка, підтвердіть пароль' appears when is required to")
    public void warningMessageAboutConfirmPasswordEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModal editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModal()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterCurrentPassword(configProperties.getAdminPassword())
                .enterNewPasswordInTheNewPasswordField("admin1");
        editProfilePassword.clickOnTheSaveChangesButton();
        Assert.assertFalse(editProfilePassword.isPresentEmptyConfirmPasswordMessage(), "Будь ласка, підтвердіть пароль");
    }

    @Test
    @Description("Test if warning message 'Будь ласка, введіть новий пароль' appears when is required to")
    public void warningMessageAboutNewPasswordEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModal editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModal()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterCurrentPassword(configProperties.getAdminPassword())
                .enterConfirmPassword("adminn");
        editProfilePassword.clickOnTheSaveChangesButton();
        Assert.assertFalse(editProfilePassword.isPresentEmptyNewPasswordFieldMessage(), "Будь ласка, введіть новий пароль");
    }

    @Test
    @Description("Test if warning message 'Введіть старий пароль' appears when is required to")
    public void warningMessageAboutCurrentPasswordEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModal editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModal()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterNewPasswordInTheNewPasswordField("adminn")
                .enterConfirmPassword("adminn");
        editProfilePassword.clickOnTheSaveChangesButton();
        Assert.assertFalse(editProfilePassword.isPresentEmptyCurrentPasswordMessage(), "Введіть старий пароль");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
