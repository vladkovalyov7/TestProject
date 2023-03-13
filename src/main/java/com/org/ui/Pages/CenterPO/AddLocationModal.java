package com.org.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModal;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class AddLocationModal extends BasePO {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameLocation;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressLocation;

    @FindBy(xpath = "//input[@id='coordinates']")
    private WebElement coordinatesLocation;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneLocation;

    @FindBy(xpath = "//div[contains(@class, 'ant-select-item-option-active') and contains(@aria-selected, 'false')]")
    private WebElement locationElement;

    @FindBy(xpath = "//input[@id='cityName']")
    private WebElement chooseCityName;

    @FindBy(xpath = "//input[@id='districtName']")
    private WebElement chooseDistrictName;

    @FindBy(xpath = "//input[@id='stationName']")
    private WebElement chooseStationName;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default flooded-button add-club-content-next']")
    private WebElement addLocationButton;

    @FindBy(xpath = "//div[@class='add-club-content-footer add-club-add-location-button']//button[@type='submit']")
    private WebElement addLocationButtonToClub;


    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    private WebElement city;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default flooded-button add-club-content-next-disabled']")
    private WebElement isLocationButtonDisabled;

    public AddLocationModal(WebDriver driver) {
        super(driver);
    }

    @Step("add location name")
    public AddLocationModal addLocationName(String locationName) {
        sleep(3);
        nameLocation.sendKeys(locationName);
        return this;
    }

    @Step("add location address")
    public AddLocationModal addLocationAddress(String locationAddress) {
        addressLocation.sendKeys(locationAddress);
        return this;
    }

    @Step("add location coordinates")
    public AddLocationModal addLocationCoordinates(String locationCoordinates) {
        coordinatesLocation.sendKeys(locationCoordinates);
        return this;
    }

    @Step("add location phone")
    public AddLocationModal addLocationPhone(String locationPhone) {
        phoneLocation.sendKeys(locationPhone);
        return this;
    }


    private AddLocationModal selectLocation(WebElement webElement, String locationName) {
        webElement.click();
        List<String> locations = new ArrayList<>();
        while (true) {
            String location = locationElement.getAttribute("title");
            if (locations.size() > 2 && locations.get(0).equals(location)) {
                System.out.println("There is no such location as " + locationName);
                break;
            }
            locations.add(location);
            if (locationName.equals(location)) {
                locationElement.click();
                break;
            }
            webElement.sendKeys(Keys.ARROW_DOWN);
        }
        return this;
    }

    @Step("choose location city")
    public AddLocationModal chooseLocationCity(String cityName) {
        selectLocation(chooseCityName, cityName);
        return this;
    }

    @Step("choose location station")
    public AddLocationModal chooseLocationStation(String stationName) {
        selectLocation(chooseStationName, stationName);
        return this;
    }

    @Step("choose location district")
    public AddLocationModal chooseLocationDistrict(String districtName) {
        selectLocation(chooseDistrictName, districtName);
        return this;
    }

    @Step("click add location button")
    public AddCenterModal clickAddLocationButton() {
        addLocationButton.click();
        return new AddCenterModal(driver);
    }

    @Step("click add location button")
    public AddClubModal clickAddLocationButtonToClub() {
        addLocationButtonToClub.click();
        sleep(3);
        return new AddClubModal(driver);
    }

    @Step("is add location button disabled")
    public boolean isAddLocationButtonDisabled() {
        return isLocationButtonDisabled.getAttribute("class").contains("disabled");
    }

}
