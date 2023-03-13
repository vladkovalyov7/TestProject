package com.org.ui;

import com.ita.edu.speakua.jdbc.entity.CentersEntity;
import com.ita.edu.speakua.jdbc.services.CentersService;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddLocationModal;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class AddCenterTest extends BaseTestRunner {
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

    @Description("Check if error appears  when add new center with empty fields")
    @Test
    public void checkIfErrorAppearsAfterEmptyFields() {
        boolean message = new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModal()
                .clickNextStep()
                .isMessageErrorCenterWithoutName();
        Assert.assertTrue(message, "Error message 'Некоректна назва центру’ doesn't appear under 'Назва центру' field with empty 'Назва центру' field");
    }


    @Description("Add center test")
    @Test
    public void addCenterTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String centerName = "New Center Name " + timestamp;
        String phoneNumber = "0661111111";
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModal()
                .enterCenterName(centerName)
                .addLocation()
                .addLocationName("New Location name " + timestamp)
                .chooseLocationCity("Харків")
                .chooseLocationStation("23 Серпня")
                .chooseLocationDistrict("Київський")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("49.9935, 36.2304")
                .addLocationPhone(phoneNumber)
                .clickAddLocationButton()
                .selectCenterLocation()
                .clickNextStep()
                .centerContactsTelephone(phoneNumber)
                .centerContactsEmail("admin@com.ua")
                .centerContactsSkype("Skype")
                .clickNextStep()
                .addLogo("centerLogo.png")
                .addPhoto("centerPhoto.jpeg")
                .addDescription("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.")
                .clickNextStep()
                .selectClub()
                .finishAddCenter();
        CentersService service = new CentersService();
        CentersEntity center = service.getByName(centerName);
        Assert.assertNotNull(center);
        Assert.assertEquals(center.getName(),  centerName);
    }

    @Description("Add center without optional fields")
    @Test
    public void addCenterOptionalTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String phoneNumber = "0661111111";
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModal()
                .enterCenterName("New Center Name " + timestamp)
                .addLocation()
                .addLocationName("New Location name " + timestamp)
                .chooseLocationCity("Харків")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("50.4485253, 30.4735083")
                .addLocationPhone(phoneNumber)
                .clickAddLocationButton()
                .selectCenterLocation()
                .clickNextStep()
                .centerContactsTelephone(phoneNumber)
                .clickNextStep()
                .addDescription("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.").clickNextStep()
                .selectClub()
                .finishAddCenter();
        Assert.assertEquals(driver.getTitle(), "Навчай українською");
    }


    @Description("This test case verifies that a 'Керівник' cannot add a location to the list of locations after leaving all mandatory and optional fields empty")
    @Test
    public void addCenterEmptyTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModal()
                .enterCenterName("New Center Name " + timestamp)
                .addLocation();
        Assert.assertTrue(new AddLocationModal(driver).isAddLocationButtonDisabled(), "Button 'Додати' is disabled");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
