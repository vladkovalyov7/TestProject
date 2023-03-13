package com.org.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactsCenterModal extends BasePO {

    @FindBy(xpath = "//input[@id='contacts_contactFacebook']")
    private WebElement contactFacebook;

    @FindBy(xpath = "//input[@id='contacts_contactContact']")
    private WebElement contactWebSite;
    @FindBy(xpath = "//input[@id='contacts_contactПошта']")
    private WebElement contactEmail;

    @FindBy(xpath = "//input[@id='contacts_contactSkype']")
    private WebElement contactSkype;

    @FindBy(xpath = "//input[@id='contacts_contactWhatsApp']")
    private WebElement contactWhatsApp;

    @FindBy(xpath = "//input[@id='contacts_contactТелефон']")
    private WebElement contactTelephone;

    @FindBy(xpath = "//span[contains(text(),'Наступний крок')]")
    private WebElement nextButton;


    public AddContactsCenterModal(WebDriver driver) {
        super(driver);
    }

    @Step("add facebook contact")
    public AddContactsCenterModal centerContactsFacebook(String facebook) {
        contactFacebook.sendKeys(facebook);
        return this;
    }

    @Step("add website")
    public AddContactsCenterModal centerContactsWebSite(String webSite) {
        contactWebSite.sendKeys(webSite);
        return this;
    }

    @Step("check if error message appears when canter without name")
    public boolean isMessageErrorCenterWithoutName() {
        try {
            driver.findElement(By.xpath("//div[contains(text(), 'Некоректна назва центру')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("add email")
    public AddContactsCenterModal centerContactsEmail(String email) {
        contactEmail.sendKeys(email);
        return this;
    }

    @Step("add skype contact")
    public AddContactsCenterModal centerContactsSkype(String skype) {
        contactSkype.sendKeys(skype);
        return this;
    }

    @Step("add watsapp contact")
    public AddContactsCenterModal centerContactsWhatsApp(String whatsApp) {
        contactWhatsApp.sendKeys(whatsApp);
        return this;
    }

    @Step("add telephone number")
    public AddContactsCenterModal centerContactsTelephone(String telephone) {
        wait.visibility(contactTelephone);
        contactTelephone.sendKeys(telephone);
        return this;
    }

    @Step("click next step")
    public AddDescriptionCenterModal clickNextStep() {
        nextButton.click();
        return new AddDescriptionCenterModal(driver);
    }

}
