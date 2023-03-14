package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePO {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.leftside-3 > div.block.block-category-navigation > div.listbox > ul > li:nth-child(2) > a")
    private WebElement computersButton;

    @FindBy(xpath = "body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.side-2 > div.block.block-category-navigation > div.listbox > ul > li.active > ul > li:nth-child(1) > a")
    private WebElement desktopButton;






//    @FindBy(xpath = "//div[contains(@class, 'user-profile')]")
//    private WebElement profileMenuButton;

//
//    public AdminProfileMenu openAdminProfileMenu() {
//        wait.clickable(profileMenuButton);
//        profileMenuButton.click();
//        sleep(3);
//        return new AdminProfileMenu(driver);
//    }
//
//    @Step("Click Club in header")
//    public ClubsPage clickClub() {
//        clubButton.click();
//        return new ClubsPage(this.driver);
//    }

}
