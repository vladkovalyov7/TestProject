package com.org.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePO{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.product-name")
    private WebElement productName;

    @FindBy(css = "span.product-subtotal")
    private List<WebElement> totalItemField;

    @FindBy(xpath = "//input[@name='removefromcart']")
    private List<WebElement> removeProductButton;

    @FindBy(xpath = "//input[@name='updatecart']")
    private WebElement updateCartButton;

    public String getNameProduct(){
        wait.visibility(productName);
        return productName.getText();
    }

    public ProductPage openProduct(){
        productName.click();
        return new ProductPage(driver);
    }

    public String getSumItem(){
        return totalItemField.get(1).getText();
    }

    public CartPage removeProduct(){
        removeProductButton.get(0).click();
        removeProductButton.get(1).click();
        updateCartButton.click();
        return new CartPage(driver);
    }
}
