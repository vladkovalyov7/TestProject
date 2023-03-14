package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopPage extends BasePO{
    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "[id='products-pagesize']")
    private WebElement displaySelectButton;

    @FindBy(xpath = "//option[text()='4']")
    private WebElement DisplaySelect4Button;

    @FindBy(xpath = "h2.product-title")
    private List<WebElement> listComputersTitle;

    @FindBy(xpath = "[id='products-orderby']")
    private WebElement sortBySelectButton;

    @FindBy(xpath = "//option[text()='Price: High to Low']")
    private WebElement sortBySelectHighToLowButton;
}
