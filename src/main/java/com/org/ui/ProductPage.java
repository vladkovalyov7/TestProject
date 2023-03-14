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

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[8]/div/input[2]")
    private WebElement addProductToCartButton;

    @FindBy(id = "product_attribute_74_5_26_82")
    private WebElement processorFastButton;

    @FindBy(id = "product_attribute_74_6_27_85")
    private WebElement ram8GBButton;

    @FindBy(id = "product_attribute_74_8_29_88")
    private WebElement imageViewerButton;

    @FindBy(id = "product_attribute_74_8_29_89")
    private WebElement officeSuiteButton;

    @FindBy(id = "product_attribute_74_8_29_90")
    private WebElement otherOfficeSuiteButton;

    @FindBy(className = "cart-qty")
    private WebElement shoppingCartButton;

    public CartPage openCartOfProduct(){
        wait.visibility(openShoppingCart);
        action.click(openShoppingCart);
        return new CartPage(driver);
    }

    public ProductPage addProductToCart(){
        wait.visibility(addProductToCartButton);
        action.click(addProductToCartButton);
        sleep(10);
        return this;
    }

    public ProductPage chooseProcessorFast(){
        processorFastButton.click();
        return this;
    }

    public ProductPage chooseRam8GB(){
        ram8GBButton.click();
        return this;
    }

    public ProductPage chooseAvailableSoftware(){
        imageViewerButton.click();
        officeSuiteButton.click();
        otherOfficeSuiteButton.click();
        return this;
    }

    public String getCountItemsCart(){
        wait.visibility(shoppingCartButton);
        return shoppingCartButton.getText();
    }





}
