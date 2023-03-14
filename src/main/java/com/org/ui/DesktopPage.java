package com.org.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesktopPage extends BasePO{
    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "[id='products-pagesize']")
    private WebElement displaySelectButton;

    @FindBy(xpath = "//option[text()='4']")
    private WebElement displaySelect4Button;

//    @FindBy(xpath = "h2.product-title")
    public List<WebElement> listComputersTitle = driver.findElements(By.xpath("h2.product-title"));



    @FindBy(xpath = "[id='products-orderby']")
    private WebElement sortBySelectButton;

    @FindBy(xpath = "//option[text()='Price: High to Low']")
    private WebElement sortBySelectHighToLowButton;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> addToCartListProductButton;

    public DesktopPage choose4DisplaySelectMenu(){
        Select dropdown = new Select(driver.findElement(By.id("products-pagesize")));
        dropdown.selectByVisibleText("4");
        return this;
    }

    public DesktopPage openSortBySelectMenu(){
        sortBySelectButton.click();
        return this;
    }

    public DesktopPage sortBySelectHighToLow(){
        sortBySelectHighToLowButton.click();
        return this;
    }

    public ProductPage addToCartProduct(){
        addToCartListProductButton.get(1).click();
        return new ProductPage(driver);
    }

}
