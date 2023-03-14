package com.org.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComputerPage extends BasePO {

    public ComputerPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2//a[@title='Show products in category Desktops']")
    private WebElement desktopButton;

    public DesktopPage openDesktopCategory(){
        wait.visibility(desktopButton);
        desktopButton.click();
        return new DesktopPage(driver);
    }
}
