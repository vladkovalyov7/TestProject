package com.org.ui.Pages.ChallengePО;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengePage extends BasePageWithHeader {
    @FindBy(xpath = "//button[contains(@class, 'add-btn')]")
    private WebElement addChallengeButton;
    @FindBy(xpath = "//table/tbody/tr[1]/td[1]")
    private WebElement lastChallenge;

    public ChallengePage(WebDriver driver) {
        super(driver);
    }

    @Step("click Add Challenge Button")
    public AddChallengePage clickAddChallengeButton() {
        wait.visibility(addChallengeButton);
        addChallengeButton.click();
        return new AddChallengePage(driver);
    }

}
