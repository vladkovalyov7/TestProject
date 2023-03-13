package com.org.ui;

import com.ita.edu.speakua.jdbc.entity.ClubsEntity;
import com.ita.edu.speakua.jdbc.services.ClubsService;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClubsSortingTest extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    @Description("Test sorting clubs by rating in ASC order")
    public void verifyThatTheClubsCanBeSortedByRatingAsc() {
        ClubCard card = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .clearCityFieldClick()
                .clickSortByRating()
                .clickSortAscending()
                .getClubPage()
                .getCards()
                .get(0);
        int rating = card.getRatingStars();
        ClubsService service = new ClubsService();
        ClubsEntity club = service.getByRatingASC().get(0);
        double ratingByDB = club.getRating();
        Assert.assertEquals(rating, ratingByDB);
    }

    @Test
    @Description("Test sorting clubs by rating in DSC order")
    public void verifyThatTheClubsCanBeSortedByRatingDsc() {
        ClubCard card = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .clearCityFieldClick()
                .clickSortByRating()
                .clickSortAscending()
                .clickSortDescending()
                .getClubPage()
                .getCards()
                .get(0);
        int rating = card.getRatingStars();
        ClubsService service = new ClubsService();
        ClubsEntity club = service.getByRatingDSC().get(0);
        double ratingByDB = club.getRating();
        Assert.assertEquals(rating, ratingByDB);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
