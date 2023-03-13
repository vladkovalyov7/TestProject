package com.org.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseClubCenterModal extends BasePO {


    @FindBy(xpath = "//div[@class='checkbox-item'][1]/label")
    WebElement club;

    @FindBy(xpath = "//button[@class='finish-btn']")
    WebElement finishButton;

    @FindBy(xpath = "//div[@class='checkbox-item'][last()]/label")
    WebElement locationToSelect;

    public ChooseClubCenterModal(WebDriver driver) {
        super(driver);
    }

    @Step("choose club")
    public ChooseClubCenterModal selectClub() {
        wait.visibility(club);
        club.click();
        club.click();
        club.sendKeys(Keys.END);
        locationToSelect.click();
        return this;
    }

    @Step("finish add center")
    public HomePage finishAddCenter() {
        finishButton.click();
        sleep(5);
        return new HomePage(driver);
    }
}
