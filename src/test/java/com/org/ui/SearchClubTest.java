package com.org.ui;

import com.org.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchClubTest extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
//        setDriver(context);
    }

    @BeforeMethod
    public void goHomePage() {
//        driver.get(configProperties.getBaseWebUrl());
    }

//    @Test
//    public void searchByNameOfClubAttachedToTheLocation() {
//        ClubsService service = new ClubsService();
//        ClubsEntity club = service.getWhereCityName("Київ").get(0);
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
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
