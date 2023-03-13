package com.org.ui;

import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModal;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTest extends BaseTestRunner {
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
        driver.get(configProperties.getBaseWebUrl());}

    @Description("check if message about incorrectly entered fields for last name appears")
    @Test
    public void MessageAboutIncorrectlyEnteredLastNameTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileModal editProfileModel = new HomePage(driver).openUserProfileMenu().openMyProfileModal().openEditProfileModel();
        boolean isMessageMore25Characters = editProfileModel.enterLastName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn").isOpenMessageErrorLastNameContain("Прізвище не може містити більше, ніж 25 символів");
        softAssert.assertTrue(isMessageMore25Characters, "the message more 25 characters check failed");
        boolean isMessageWithSpecialCharacters = editProfileModel.deleteLastName().enterLastName("!@#$%^&,").isOpenMessageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        softAssert.assertTrue(isMessageWithSpecialCharacters, "the message with special characters check failed");
        boolean isMessageWithNumbers = editProfileModel.deleteLastName().enterLastName("1234").isOpenMessageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        softAssert.assertTrue(isMessageWithNumbers,"the message with numbers check failed" );
        boolean isMessageStartedWithHyphen = editProfileModel.deleteLastName().enterLastName("-Lastname").isOpenMessageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMessageStartedWithHyphen, "the message started with hyphen check failed" );
        boolean isMessageStartedWithSpace = editProfileModel.deleteLastName().enterLastName(" Lastname").isOpenMessageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMessageStartedWithSpace, "the message started with space check failed" );
        boolean isMessageStartedWithApostrophe = editProfileModel.deleteLastName().enterLastName("'Lastname").isOpenMessageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMessageStartedWithApostrophe, "the message started with apostrophe check failed" );
        boolean isMessageEndedWithHyphen = editProfileModel.deleteLastName().enterLastName("Lastname-").isOpenMessageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMessageEndedWithHyphen, "the message ended with hyphen check failed");
        boolean isMessageEndedWithSpace = editProfileModel.deleteLastName().enterLastName("Lastname ").isOpenMessageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMessageEndedWithSpace, "the message ended with space check failed");
        boolean isMessageEndedWithApostrophe = editProfileModel.deleteLastName().enterLastName("Lastname'").isOpenMessageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMessageEndedWithApostrophe, "the message ended with apostrophe check failed");
        boolean isMessageDeleteData = editProfileModel.deleteLastName().isOpenMessageErrorLastNameContain("Будь ласка введіть Ваше прізвище");
        softAssert.assertTrue(isMessageDeleteData, "the message delete data check failed" );
        softAssert.assertAll();
    }
    @Description("check if message about incorrectly entered fields for first name appears")
    @Test
    public void MessageAboutIncorrectlyEnteredFirstNameTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileModal editProfileModel = new HomePage(driver).openUserProfileMenu().openMyProfileModal().openEditProfileModel();
        boolean isMessageMore25Characters = editProfileModel.enterFirstName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn").isOpenMessageErrorFirstNameContain("Ім'я не може містити більше, ніж 25 символів");
        softAssert.assertTrue(isMessageMore25Characters, "the message more 25 characters in first name field check failed");
        boolean isMessageWithSpecialCharacters = editProfileModel.deleteFirstName().enterFirstName("!@#$%^&,").isOpenMessageErrorFirstNameContain("Ім’я не може містити спеціальні символи");
        softAssert.assertTrue(isMessageWithSpecialCharacters, "the message with special characters in first name field check failed");
        boolean isMessageWithNumbers = editProfileModel.deleteFirstName().enterFirstName("1234").isOpenMessageErrorFirstNameContain("Ім’я не може містити цифри");
        softAssert.assertTrue(isMessageWithNumbers,"the message with numbers in first name field check failed" );
        boolean isMessageStartedWithHyphen = editProfileModel.deleteFirstName().enterFirstName("-Name").isOpenMessageErrorFirstNameContain("Ім’я повинно починатися та закінчуватися літерою");
        softAssert.assertTrue(isMessageStartedWithHyphen, "the message started with hyphen in first name field check failed" );
        boolean isMessageStartedWithSpace = editProfileModel.deleteFirstName().enterFirstName(" Name").isOpenMessageErrorFirstNameContain("Ім’я повинно починатися та закінчуватися літерою");
        softAssert.assertTrue(isMessageStartedWithSpace, "the message started with space in first name field check failed" );
        boolean isMessageStartedWithApostrophe = editProfileModel.deleteFirstName().enterFirstName("'Name").isOpenMessageErrorFirstNameContain("Ім’я повинно починатися та закінчуватися літерою");
        softAssert.assertTrue(isMessageStartedWithApostrophe, "the message started with apostrophe in first name field check failed" );
        boolean isMessageEndedWithHyphen = editProfileModel.deleteFirstName().enterFirstName("Name-").isOpenMessageErrorFirstNameContain("Ім’я повинно починатися та закінчуватися літерою");
        softAssert.assertTrue(isMessageEndedWithHyphen, "the message ended with hyphen in first name field check failed");
        boolean isMessageEndedWithSpace = editProfileModel.deleteFirstName().enterFirstName("Name ").isOpenMessageErrorFirstNameContain("Ім’я повинно починатися та закінчуватися літерою");
        softAssert.assertTrue(isMessageEndedWithSpace, "the message ended with space in first name field check failed");
        boolean isMessageEndedWithApostrophe = editProfileModel.deleteFirstName().enterFirstName("Name'").isOpenMessageErrorFirstNameContain("Ім’я повинно починатися та закінчуватися літерою");
        softAssert.assertTrue(isMessageEndedWithApostrophe, "the message ended with apostrophe in first name field check failed");
        boolean isMessageDeleteData = editProfileModel.deleteFirstName().isOpenMessageErrorFirstNameContain("Будь ласка введіть Ваше ім'я");
        softAssert.assertTrue(isMessageDeleteData, "the message delete data in first name field check failed" );
        softAssert.assertAll();
    }
    @Description("check if message about incorrectly entered fields for number phone appears")
    @Test
    public void MessageAboutIncorrectlyEnteredNumberPhoneTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileModal editProfileModel = new HomePage(driver).openUserProfileMenu().openMyProfileModal().openEditProfileModel();
        boolean isMessageLessThan13Symbols = editProfileModel.enterNumberPhone("06895").isOpenMessageErrorPhoneContain("Телефон не відповідає вказаному формату");
        softAssert.assertTrue(isMessageLessThan13Symbols, "the message less than 13 symbols check failed");
        boolean isMessageMoreThan13Symbols = editProfileModel.deleteNumberPhone().enterNumberPhone("06593859632586").isOpenMessageErrorPhoneContain("Телефон не відповідає вказаному формату");
        softAssert.assertTrue(isMessageMoreThan13Symbols, "the message more than 13 symbols check failed");
        boolean isMessageLetters = editProfileModel.deleteNumberPhone().enterNumberPhone("jngeoлщшогнеп").isOpenMessageErrorPhoneContain("Телефон не може містити літери\n" + "Телефон не відповідає вказаному формату");
        softAssert.assertTrue(isMessageLetters, "the message letters check failed");
        boolean isMessageSpecialCharacters = editProfileModel.deleteNumberPhone().enterNumberPhone("!@#$%^&*(_+.:").isOpenMessageErrorPhoneContain("Телефон не відповідає вказаному формату\n" + "Телефон не може містити спеціальні символи");
        softAssert.assertTrue(isMessageSpecialCharacters, "the message special characters check failed");
        boolean isMessageDeleteData = editProfileModel.deleteNumberPhone().isOpenMessageErrorPhoneContain("Будь ласка введіть Ваш номер телефону");
        softAssert.assertTrue(isMessageDeleteData, "the message delete data check failed");
        softAssert.assertAll();
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
