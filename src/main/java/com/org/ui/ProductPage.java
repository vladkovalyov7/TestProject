package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePO{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Shopping cart']")
    private WebElement openShoppingCart;

    public CartPage openCartOfProduct(){
        openShoppingCart.click();
        return new CartPage(driver);
    }


}
