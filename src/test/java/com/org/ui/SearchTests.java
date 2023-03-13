package com.org.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class SearchTests extends BaseTestRunner {
    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    @Description("Test if website started search after entering one symbol in search field")
    public void oneSymbolEnteredInTheField() {
        String initial = new HomePage(driver)
                .clickSearchField()
                .getComponentsOfTheSearchList().get(2).getText();
        String afterAllActions = new HomePage(driver)
                .clickSearchField()
                .enterTextInTheSearchFieldAndWait("з", 10)
                .getComponentsOfTheSearchList().get(2).getText();
        Assert.assertNotEquals(initial, afterAllActions);
    }

    @Test
    @Description("Test if website started search after entering fifty symbols in search field")
    public void fiftySymbolsEnteredInTheSearchField() {
        new HomePage(driver).clickClub();
        String initial = new HomePage(driver)
                .clickSearchField()
                .getComponentsOfTheSearchList()
                .get(1)
                .getText();
        String afterAllActions = new HomePage(driver)
                .clickSearchField()
                .enterTextInTheSearchFieldAndWait("лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1", 3)
                .getComponentsOfTheSearchList().get(1).getAttribute("title");
        Assert.assertNotEquals(initial, afterAllActions);
    }

    @Test
    @Description("Test if website started search after entering more than fifty symbols in search field")
    public void moreThanFiftySymbolsEnteredInTheSearchField() {
        String inputData = "лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1234567890";
        String cutInputData = new HomePage(driver)
                .clickSearchField()
                .enterTextInTheSearchField(inputData)
                .getSearchFieldInputValue();
        Assert.assertEquals(cutInputData, "лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
