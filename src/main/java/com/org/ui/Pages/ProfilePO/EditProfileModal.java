package com.org.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfileModal extends BasePO {
    @FindBy(xpath = "//input[@id='edit_lastName']")
    private WebElement editLastNameField;

    @FindBy(xpath = "//input[@id='edit_firstName']")
    private WebElement editFirstNameField;

    @FindBy(xpath = "//input[@id='edit_phone']")
    private WebElement editNumberPhoneField;

    @FindBy(xpath = "//*[@id='edit_currentPassword']")
    private WebElement currentPasswordField;

    @FindBy(xpath = "//*[@id='edit_password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//*[@id='edit']/div[2]/div[10]/button")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//div[@class='ant-form-item-explain-error']")
    private WebElement messageAboutIncorrectlyEnteredLastName;

    @FindBy(xpath = "//*[@id='edit_currentPassword_help']/div")
    private WebElement emptyCurrentPasswordFieldMessage;

    @FindBy(xpath = "//*[@id='edit_password_help']/div")
    private WebElement emptyNewPasswordFieldMessage;
    @FindBy(xpath = "//*[@id='edit_confirmPassword_help']/div")
    private WebElement emptyConfirmPasswordMessage;

    @FindBy(xpath = "//div[2]/div[7]/div/input")
    private WebElement changePasswordCheckBox;

    public EditProfileModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click Change password check box")
    public EditProfileModal clickChangePasswordCheckBox() {
        sleep(5);
        changePasswordCheckBox.click();
        return this;
    }
    @Step("check if error message for last name field contains required string")
    public boolean isOpenMessageErrorLastNameContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("check if error message for first name field contains required string")
    public boolean isOpenMessageErrorFirstNameContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentEmptyConfirmPasswordMessage() {
        try {
            driver.findElement(By.xpath(String.valueOf(emptyConfirmPasswordMessage.isDisplayed())));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentEmptyCurrentPasswordMessage() {
        try {
            driver.findElement(By.xpath(String.valueOf(emptyCurrentPasswordFieldMessage.isDisplayed())));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentEmptyNewPasswordFieldMessage() {
        try {
            driver.findElement(By.xpath(String.valueOf(emptyNewPasswordFieldMessage.isDisplayed())));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Step("check if error message for number phone field contains required string")
    public boolean isOpenMessageErrorPhoneContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Enter current password")
    public EditProfileModal enterCurrentPassword(String password) {
        sleep(5);
        currentPasswordField.sendKeys(password);
        return this;
    }

    @Step("Enter new password")
    public EditProfileModal enterNewPasswordInTheNewPasswordField(String newPassword) {
        newPasswordField.sendKeys(newPassword);
        return this;
    }

    @Step("Enter new password in the Confirm new password field")
    public EditProfileModal enterConfirmPassword(String password) {
        currentPasswordField.sendKeys(password);
        return this;
    }

    @Step("Click Save changes button")
    public MyProfilePage clickOnTheSaveChangesButton() {
        saveChangesButton.click();
        return new MyProfilePage(driver);
    }

    @Step("enter last name")
    public EditProfileModal enterLastName(String lastName) {
        editLastNameField.clear();
        wait.visibility(editLastNameField);
        editLastNameField.sendKeys(lastName);
        return this;
    }

    @Step("enter first name")
    public EditProfileModal enterFirstName(String firstName) {
        wait.visibility(editFirstNameField);
        editFirstNameField.sendKeys(firstName);
        return this;
    }

    @Step("delete last name")
    public EditProfileModal deleteLastName() {
        editLastNameField.sendKeys(Keys.CONTROL + "a");
        editLastNameField.sendKeys(Keys.DELETE);
        wait.visibility(editLastNameField);
        return this;
    }

    @Step("delete first name")
    public EditProfileModal deleteFirstName() {
        editFirstNameField.sendKeys(Keys.CONTROL + "a");
        editFirstNameField.sendKeys(Keys.DELETE);
        return this;
    }
    @Step("enter number phone")
    public EditProfileModal enterNumberPhone(String numberPhone) {
        wait.visibility(editNumberPhoneField);
        editNumberPhoneField.sendKeys(numberPhone);
        return this;
    }
    @Step("delete number phone")
    public EditProfileModal deleteNumberPhone() {
        editNumberPhoneField.sendKeys(Keys.CONTROL + "a");
        editNumberPhoneField.sendKeys(Keys.DELETE);
        wait.visibility(editNumberPhoneField);
        return this;
    }
}
