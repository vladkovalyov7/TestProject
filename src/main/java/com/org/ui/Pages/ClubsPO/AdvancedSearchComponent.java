package com.org.ui.Pages.ClubsPO;
//
//import com.ita.edu.speakua.ui.BasePO;
//import io.qameta.allure.Step;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//import java.util.List;
//
//public class AdvancedSearchComponent extends BasePO {
//
//    @FindBy(xpath = "//div[contains(@class,'ant-card-body')]")
//    protected List<WebElement> cardsBody;
//    @FindBy(xpath = "//input[@value='LIST']//ancestor::label")
//    private WebElement controlViewList;
//    @FindBy(xpath = "//input[@value='BLOCK']//ancestor::label")
//    private WebElement controlViewBlock;
//    private List<ClubCard> cards;
//    @FindBy(xpath = "//label[.//span[contains(text(),'Центр')]]//span//input[@type='radio']")
//    private WebElement radioCenter;
//    @FindBy(xpath = "//label[.//span[contains(text(),'Гурток')]]//span//input[@type='radio']")
//    private WebElement radioClub;
//    @FindBy(xpath = "//label[.//span[@class='ant-radio ant-radio-checked']]//span[not(@class)]")
//    private WebElement radioValue;
//    @FindBy(xpath = "//input[@id='basic_cityName']//ancestor::div[contains(@class,'selector')]")
//    private WebElement dropDownCity;
//    @FindBy(xpath = "//*[@id='basic_cityName']")
//    private WebElement cityInputField;
//
//    @FindBy(xpath = "//span[(@class='ant-select-clear')]")
//    private WebElement clearCity;
//
//    @FindBy(xpath = "//div[@id='basic_cityName_list']/ancestor::div[not(@class)][1]")
//    private WebElement dropDownCityList;
//    @FindBy(xpath = "//input[@id='basic_districtName']//ancestor::div[contains(@class,'selector')]")
//    private WebElement dropDownDistrict;
//    @FindBy(xpath = "//input[@id='basic_stationName']//ancestor::div[contains(@class,'selector')]")
//    private WebElement dropDownStation;
//    @FindBy(xpath = "//input[@class='ant-input-number-input']")
//    private WebElement inputAgeChildField;
//    @FindBy(xpath = "//span[@id='basic_age']")
//    private WebElement valueAgeChildField;
//    @FindBy(xpath = "//div[@id='basic_isOnline']//span[.//input]")
//    private WebElement checkBoxRemote;
//    @FindBy(xpath = "//span[text()='за алфавітом']")
//    private WebElement sortAlphabetical;
//    @FindBy(xpath = "//span[@class='anticon anticon-arrow-up control-sort-arrow']")
//    private WebElement sortDescending;
//    @FindBy(xpath = "//span[@class='anticon anticon-arrow-down control-sort-arrow']")
//    private WebElement sortAscending;
//    @FindBy(xpath = "//span[text()='за рейтингом']")
//    private WebElement sortByRating;
//
//
//    public AdvancedSearchComponent(WebDriver driver) {
//        super(driver);
//    }
//
//    public AdvancedSearchComponent clickControlViewList() {
//        controlViewList.click();
//        return this;
//    }
//
//    public AdvancedSearchComponent clickControlViewBlock() {
//        controlViewBlock.click();
//        return this;
//    }
//
//    public boolean controlViewDisplay() {
//        // Returns TRUE if the view is marked as LIST
//        // Returns FALSE if the view is marked as BLOCK
//
//        int firstCard = cardsBody.get(0).getLocation().getY();
//        int secondCard = cardsBody.get(1).getLocation().getY();
//
//        return firstCard < secondCard;
//    }
//
//    public boolean isCityActive() {
//        try {
//            wait.visibility(dropDownCity);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean isDistrictActive() {
//        try {
//            wait.visibility(dropDownDistrict);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean isStationActive() {
//        try {
//            wait.visibility(dropDownStation);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean isAgeChildActive() {
//        try {
//            wait.visibility(inputAgeChildField);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean isRemoteActive() {
//        try {
//            wait.visibility(checkBoxRemote);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean isCategoryActive() {
//        try {
//            wait.visibility(By.xpath("//span[contains(text(), '')]"));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    @Step("Click center button")
//    public AdvancedSearchComponent clickRadioCenter() {
//        radioCenter.click();
//        return this;
//    }
//
//    public AdvancedSearchComponent clickRadioClub() {
//        radioClub.click();
//        return this;
//    }
//
//    public AdvancedSearchComponent clickRemote() {
//        checkBoxRemote.click();
//        return this;
//    }
//
//    @Step("Advanced search is opened")
//    public boolean isAdvancedSearchOpen() {
//        try {
//            wait.visibility(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
//            int advancedSearchMenu = driver.findElement(By.xpath("//aside[contains(@class, 'club-list-side')]")).getLocation().getX();
//            int contentList = driver.findElement(By.xpath("//div[contains(@class,'content-clubs-list')]")).getLocation().getX();
//
//            if (!(advancedSearchMenu < contentList)) {
//                throw new Exception("Advanced search menu does not display properly");
//            }
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String getRadioValueString() {
//        return radioValue.getText();
//    }
//
//    @Step("Value entered number age")
//    public String getAgeChildField() {
//        return valueAgeChildField.getAttribute("value");
//    }
//
//    @Step("Enter number age")
//    public AdvancedSearchComponent enterNumberAge(String ageNumber) {
//        wait.visibility(inputAgeChildField);
//        inputAgeChildField.sendKeys(Keys.CONTROL + "a");
//        inputAgeChildField.sendKeys(Keys.DELETE);
//        inputAgeChildField.sendKeys(ageNumber);
//        sleep(2);
//        return this;
//    }
//
//    @Step("Click sort Alphabetically")
//    public AdvancedSearchComponent clickSortAlphabetical() {
//        wait.visibility(sortAlphabetical);
//        action.click(sortAlphabetical);
//        sleep(2);
//        return this;
//    }
//
//    @Step("Click sort DSC")
//    public AdvancedSearchComponent clickSortDescending() {
//        wait.visibility(sortDescending);
//        action.click(sortDescending);
//        sleep(2);
//        return this;
//    }
//
//    @Step("Click sort ASC")
//    public AdvancedSearchComponent clickSortAscending() {
//        wait.visibility(sortAscending);
//        action.click(sortAscending);
//        sleep(2);
//        return this;
//    }
//
//    @Step("Click Sort by Rating")
//    public AdvancedSearchComponent clickSortByRating() {
//        sortByRating.click();
//        return this;
//    }
//
//    public ClubsPage clickSortByRatingReturnClubs() {
//        sortByRating.click();
//        return new ClubsPage(driver);
//    }
//
//
//
//    public AdvancedSearchComponent clearCityField() {
//        cityInputField.findElement(By.xpath("//span[@class='ant-select-arrow']")).click();
//        return this;
//    }
//
//    @Step("Clear city field")
//    public AdvancedSearchComponent clearCityFieldClick() {
//        clearCity.click();
//        return this;
//    }
//
//    public ClubsPage getClubPage() {
//        sleep(2);
//        return new ClubsPage(driver);
//    }
//
//
//}
