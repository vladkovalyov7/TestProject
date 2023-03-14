package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePO {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Computers')]")
    private WebElement computersButton;


    public ComputerPage openComputersCategory(){
        computersButton.click();
        return new ComputerPage(driver);
    }

}
