package com.org.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class AddLocationToClubTest extends BaseTestRunner {
    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }
    @Description("Add center to club")
    @Test
    public void addCenterTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String clubName = "New Club to test add location " + timestamp;
        String clubDescription = "Some description of club in English #$^*@ Опис клубу українською мовою Some description of club in English #$^*@ Опис клубу українською мовою";
        String phoneNumber = "0661111111";
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddClubModal()
                .enterNameClub(clubName)
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("5")
                .enterToAge("10")
                .clickNextStep()
                .clickAddLocationButton()
                .addLocationName("New Location name " + timestamp)
                .chooseLocationCity("Харків")
                .chooseLocationStation("23 Серпня")
                .chooseLocationDistrict("Київський")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("49.9935, 36.2304")
                .addLocationPhone(phoneNumber)
                .clickAddLocationButtonToClub()
                .enterPhoneNumber(phoneNumber)
                .clickNextStep()
                .enterClubDescription(clubDescription)
                .finishAddingCenter();
        new HomePage(driver)
                .openUserProfileMenu()
                .openMyProfileModal()
                .clickLastElementOfTheListOfCenters()
                .getClubsPage()
                .getCardByName(clubName)
                .getDetailInformation();
        String checkInformationAboutCenterByNumber = new ClubPage(driver)
                .getNumberPhone();
        Assert.assertEquals(checkInformationAboutCenterByNumber, "+38" + phoneNumber);
        String checkInformationAboutCenterByDescription = new ClubPage(driver).getDescriptionAboutCenter();
        Assert.assertEquals(checkInformationAboutCenterByDescription, clubDescription);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
