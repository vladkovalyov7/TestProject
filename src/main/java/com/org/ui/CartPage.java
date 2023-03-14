package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePO{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "a.product-name")
    private WebElement productName;

    public CartPage getNameProduct(){
        productName.getText();
        return this;
    }

}
