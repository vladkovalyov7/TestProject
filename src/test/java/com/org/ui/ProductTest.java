package com.org.ui;

import com.org.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductTest extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
    }

    @BeforeMethod
    public void goHomePage() {
        driver.navigate().to("http://demowebshop.tricentis.com/");
    }

    @Test
    public void addProductToCart() {
        String nameProduct = "Build your own expensive computer";
      new HomePage(driver)
              .openComputersCategory();
      new ComputerPage(driver)
              .openDesktopCategory();
      new DesktopPage(driver)
              .choose4DisplaySelectMenu();
      List<WebElement> listComputersTitle = driver.findElements(By.cssSelector("h2.product-title"));
      SoftAssert softAssert = new SoftAssert();
      softAssert.assertEquals(listComputersTitle.size(),4);
      new DesktopPage(driver)
              .SortByHighToLow()
              .chooseProduct();
      new ProductPage(driver)
              .addProductToCart()
              .openCartOfProduct();
      String name = new CartPage(driver)
              .getNameProduct();
      Assert.assertEquals(name,nameProduct);
      new CartPage(driver)
              .openProduct();
      String countItemsCart = new ProductPage(driver)
              .chooseProcessorFast()
              .chooseRam8GB()
              .chooseAvailableSoftware()
              .addProductToCart()
              .getCountItemsCart();
      softAssert.assertEquals(countItemsCart,"(2)");
      String sumSecondItem = new ProductPage(driver)
              .openCartOfProduct()
              .getSumItem();
      softAssert.assertEquals(sumSecondItem,"2105.00");
      new CartPage(driver)
              .removeProduct();
      softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
