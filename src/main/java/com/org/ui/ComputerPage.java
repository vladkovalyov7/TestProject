package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends BasePO {

    public ComputerPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.side-2 > div.block.block-category-navigation > div.listbox > ul > li.active > ul > li:nth-child(1) > a")
    private WebElement desktopButton;
}
