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
              .openSortBySelectMenu()
              .sortBySelectHighToLow()
              .addToCartProduct();
      new ProductPage(driver)
              .openCartOfProduct();
      String name = new CartPage(driver)
              .getNameProduct().toString();
      Assert.assertEquals(name,"Build your own expensive computer");
        softAssert.assertAll();

//        String nameOfClubFromDB = club.getName();
//        String resultOfSearch = new HomePage(driver)
//                .clickLocationButton()
//                .clickCityInTheLocationSection(0)
//                .enterTextInTheSearchField(nameOfClubFromDB)
//                .clickSearchButton()
//                .getCards()
//                .get(0)
//                .getTitle();
//        Assert.assertEquals(resultOfSearch, nameOfClubFromDB);
//        ClubsEntity clubByNameFromDB = service.getByName(nameOfClubFromDB);
//        Assert.assertEquals(clubByNameFromDB.getName(), resultOfSearch);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
