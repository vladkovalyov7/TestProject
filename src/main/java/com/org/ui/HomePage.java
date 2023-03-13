package com.org.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePO {


    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class, 'user-profile')]")
    private WebElement profileMenuButton;


    @Step("Enter text in search field")
    public HeaderComponent enterTextInTheSearchField(String input) {
        searchField.sendKeys(input);
        return this;
    }

    @Step("Enter text in search field")
    public HeaderComponent enterTextInTheSearchFieldAndWait(String input, int timeToWait) {
        searchField.sendKeys(input);
        sleep(timeToWait);
        return this;
    }

    @Step("Click search button")
    public ClubsPage clickSearchButton() {
        searchButton.click();
        return new ClubsPage(driver);
    }

    @Step("Open profile menu")
    public GuestProfileMenu openGuestProfileMenu() {
        wait.clickable(profileMenuButton);
        profileMenuButton.click();
        sleep(3);
        return new GuestProfileMenu(driver);
    }

    @Step("Open Admin profile Menu")
    public AdminProfileMenu openAdminProfileMenu() {
        wait.clickable(profileMenuButton);
        profileMenuButton.click();
        sleep(3);
        return new AdminProfileMenu(driver);
    }

    @Step("Click Club in header")
    public ClubsPage clickClub() {
        clubButton.click();
        sleep(3);
        return new ClubsPage(this.driver);
    }

}
