package com.org.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubPage extends BasePageWithHeader {

    @FindBy(xpath = "//span[@class='contact-name']")
    private WebElement fieldNumberPhone;

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/section/aside/div/div[3]/div/div[1]/span/a")
    private WebElement fieldLoginSkype;

    @FindBy(xpath = "//div[@class='content']")
    private WebElement fieldDescriptionAboutCenter;

    public ClubPage(WebDriver driver) {
        super(driver);
    }

    public String getDescriptionAboutCenter() {
        wait.visibility(fieldDescriptionAboutCenter);
       return fieldDescriptionAboutCenter.getText();
    }

    public String getNumberPhone() {
        wait.visibility(fieldNumberPhone);
        return fieldNumberPhone.getText();
    }

    public String getLoginOfSkype() {
        wait.visibility(fieldLoginSkype);
        return fieldLoginSkype.getText();
    }

}
