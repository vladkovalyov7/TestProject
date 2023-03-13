package com.org.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class AddDescriptionCenterModal extends BasePO {
    @FindBy(xpath = "//input[@id='basic_urlLogo']")
    private WebElement addLogo;

    @FindBy(xpath = "//input[@id='basic_urlBackground']")
    private WebElement addPhoto;

    @FindBy(xpath = "//textarea[@id='basic_description']")
    private WebElement addDescription;
    @FindBy(xpath = "//span[contains(text(),'Наступний крок')]")
    private WebElement nextButton;


    public AddDescriptionCenterModal(WebDriver driver) {
        super(driver);
    }

    @Step("add logo")
    public AddDescriptionCenterModal addLogo(String logo) {
        File file = new File(getClass().getClassLoader().getResource(logo).getFile());
        String imagePath = file.getAbsolutePath();

        addLogo.sendKeys(imagePath);
        return this;
    }

    @Step("add photo")
    public AddDescriptionCenterModal addPhoto(String photo) {
        File file = new File(getClass().getClassLoader().getResource(photo).getFile());
        String imagePath = file.getAbsolutePath();
        addPhoto.sendKeys(imagePath);
        return this;
    }

    @Step("add description")
    public AddDescriptionCenterModal addDescription(String description) {
        wait.visibility(addDescription);
        addDescription.sendKeys(description);
        return this;
    }

    @Step("click next step")
    public ChooseClubCenterModal clickNextStep() {
        nextButton.click();
        return new ChooseClubCenterModal(driver);
    }
}
