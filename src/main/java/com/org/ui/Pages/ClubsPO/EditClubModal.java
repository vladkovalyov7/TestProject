package com.org.ui.Pages.ClubsPO;
//
//import com.ita.edu.speakua.ui.BasePO;
//import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class EditClubModal extends BasePO {
//
//    @FindBy(xpath = "//div[text()='Адреса і контакти']")
//    private WebElement addressAndContactsButton;
//
//
//    @FindBy(id = "basic_clubContactТелефон")
//    private WebElement phoneNumberInput;
//
//    @FindBy(xpath = "//div[text()='Опис гуртка']")
//    private WebElement descriptionButton;
//
//    @FindBy(id = "basic_descriptionText")
//    private WebElement clubDescriptionInput;
//
//    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/button[1]/span")
//    private WebElement saveInContactSectionButton;
//
//    @FindBy(xpath = "//span[text()='Наступний крок']")
//    private WebElement nextStepButton;
//
//    @FindBy(xpath = "//span[text()='Завершити']")
//    private WebElement theEndButton;
//
//    @FindBy(xpath = "//div[@tabindex='0']/form[@class='ant-form ant-form-horizontal']/div[5]//span[text()='Зберегти гурток']")
//    private WebElement saveInDescriptionSectionButton2;
//    @FindBy(xpath = "//input[@id='basic_Skype']")
//    private WebElement loginOfSkypeInput;
//
//    public EditClubModal(WebDriver driver) {
//        super(driver);
//    }
//
//    public EditClubModal nextStepClick() {
//        sleep(7);
//        wait.visibility(nextStepButton);
//        action.click(nextStepButton);
//        sleep(7);
//        return this;
//    }
//
//    public EditClubModal enterPhoneNumber(String phoneNumber) {
//        wait.visibility(phoneNumberInput);
//        phoneNumberInput.clear();
//        phoneNumberInput.sendKeys(Keys.DELETE);
//        phoneNumberInput.sendKeys(phoneNumber);
//        return this;
//    }
//
//    public EditClubModal openDescriptionSection() {
//        wait.visibility(descriptionButton);
//        action.click(descriptionButton);
//        return this;
//    }
//
//    public EditClubModal enterClubDescription(String clubDescription) {
//        clubDescriptionInput.clear();
//        clubDescriptionInput.sendKeys(clubDescription);
//        return this;
//    }
//
//    public EditClubModal clickSaveInContactSectionButton() {
//        wait.visibility(saveInContactSectionButton);
//        action.click(saveInContactSectionButton);
//        return this;
//    }
//
//    public MyProfilePage clickTheEnd() {
//        wait.visibility(theEndButton);
//        action.click(theEndButton);
//        return new MyProfilePage(driver);
//    }
//
//    public EditClubModal enterLoginOfSkype(String login) {
//        sleep(5);
//        loginOfSkypeInput.sendKeys(login);
//        return this;
//    }
//
//}
