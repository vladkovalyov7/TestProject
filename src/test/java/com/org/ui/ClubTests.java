package com.org.ui;
//
//
//import com.org.ui.Pages.ClubsPO.AddClubModal;
//import com.org.ui.Pages.ClubsPO.ClubPage;
//import com.org.ui.Pages.ProfilePO.MyProfilePage;
//import com.org.ui.runners.BaseTestRunner;
//import jdk.jfr.Description;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//public class ClubTests extends BaseTestRunner {

//    @BeforeClass
//    public void setUp(ITestContext context) {
//        setDriver(context);
//        new HomePage(driver)
//                .openGuestProfileMenu()
//                .openLoginModel()
//                .enterEmail(configProperties.getAdminEmail())
//                .enterPassword(configProperties.getAdminPassword())
//                .clickLogin();
//    }
//
//    @BeforeMethod
//    public void goHomePage() {
//        driver.get(configProperties.getBaseWebUrl());
//    }
//
//    @Test
//    public void addVerifyDescriptionClubTest() {
//        AddClubModal addClubModal = new HomePage(driver)
//                .openUserProfileMenu()
//                .openAddClubModal()
//                .enterNameClub("Спорт")
//                .selectCategoryByName("Спортивні секції")
//                .enterFromAge("5")
//                .enterToAge("10")
//                .clickNextStep()
//                .enterPhoneNumber("0932584213")
//                .clickNextStep();
//
//
//        SoftAssert softAssert = new SoftAssert();
//        //TUA-176
//        softAssert.assertTrue(addClubModal.enterClubDescription("В гурток ходить 3 людини").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
//        softAssert.assertTrue(addClubModal.enterClubDescription("!").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
//        softAssert.assertTrue(addClubModal.enterClubDescription("Заняття проходять тричі рази на тиждень").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
//        //TUA-177
//        softAssert.assertTrue(addClubModal.enterClubDescription("Вихованці гуртка приймають активну участь як у міських, так і у обласних, Всеукраїнських та міжнародних змаганнях, Чемпіонатах та Кубках України серед юнаків де показують стабільно високі результати. Всі вони входять до збірної команди Львівської області з легкої атлетики.\n" +
//                "Батьки вихованців беруть дуже активну участь у житті гуртка. Вони відвідують батьківські збори, тренування, допомагають у суддівстві, у придбанні інвентарю, спортивної форми.\n" +
//                "Ведення учнями малорухливого способу життя призводить до таких наслідків як: збільшення індексу маси тіла, невпевненість в собі тощо. Одним з шляхів вирішення даної проблеми є створення мережі спортивних гуртків для навчальних закладів, які відповідають інтересам та потребам сучасного молодого покоління.\n" +
//                "Наш гурток має низку переваг: \n" +
//                "- Фізичний розвиток: сприяють загальному фізичному розвитку, зміцнюють здоров'я, розвивають спритність і координацію рухів, виробляють м'язову силу;\n" +
//                "- Психічний розвиток: допомагають виробити силу волі, наполегливість, впевненість у собі, вміння постояти за себе, вміння терпіти біль і втому, долати перешкоди, навички роботи в команді;\n" +
//                "- Додаткові переваги: хороший відпочинок після тривалого сидіння за партою, можливість дитині виплеснути накопичену енергію в конструктивній формі. Спортивні секції можуть бути найрізноманітнішими: хокей, волейбол, баскетбол, футбол, теніс, різні види боротьби, легка атлетика, батут, басейн. Всього і не перерахуєш. У кожного виду спорту своя специфіка. \n" +
//                "Вибір лише за вами...").successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.enterClubDescription("'Education', 'students', 'Школа' 'балету'").successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.enterClubDescription("Вихованці гуртка приймають активну участь як у міських, так і у обласних, Всеукраїнських та міжнародних змаганнях, Чемпіонатах та Кубках України серед юнаків де показують стабільно високі результати. Всі вони входять до збірної команди Львівської області з легкої атлетики.\n" +
//                "Батьки вихованців беруть дуже активну участь у житті гуртка. Вони відвідують батьківські збори, тренування, допомагають у суддівстві, у придбанні інвентарю, спортивної форми.\n" +
//                "Ведення учнями малорухливого способу життя призводить до таких наслідків як: збільшення індексу маси тіла, невпевненість в собі тощо. Одним з шляхів вирішення даної проблеми є створення мережі спортивних гуртків для навчальних закладів, які відповідають інтересам та потребам сучасного молодого покоління.\n" +
//                "Наш гурток має низку переваг: \n" +
//                "- Фізичний розвиток: сприяють загальному фізичному розвитку, зміцнюють здоров'я, розвивають спритність і координацію рухів, виробляють м'язову силу;\n" +
//                "- Психічний розвиток: допомагають виробити силу волі, наполегливість, впевненість у собі, вміння постояти за себе, вміння терпіти біль і втому, долати перешкоди, навички роботи в команді;\n" +
//                "- Додаткові переваги: хороший відпочинок після тривалого сидіння за партою, можливість дитині виплеснути накопичену енергію в конструктивній формі. Спортивні секції можуть бути найрізноманітнішими: хокей, волейбол, баскетбол, футбол, теніс, різні види боротьби, легка атлетика, батут, басейн. Всього і не перерахуєш. У кожного виду спорту своя специфіка. \n" +
//                "Вибір лише за вами....").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
//        softAssert.assertTrue(addClubModal.enterClubDescription("Вихованці гуртка приймають активну участь як у міських, так і у обласних, Всеукраїнських та міжнародних змаганнях, Чемпіонатах та Кубках України серед юнаків де показують стабільно високі результати. Всі вони входять до збірної команди Львівської області з легкої атлетики.\n" +
//                "Батьки вихованців беруть дуже активну участь у житті гуртка. Вони відвідують батьківські збори, тренування, допомагають у суддівстві, у придбанні інвентарю, спортивної форми.\n" +
//                "Ведення учнями малорухливого способу життя призводить до таких наслідків як: збільшення індексу маси тіла, невпевненість в собі тощо. Одним з шляхів вирішення даної проблеми є створення мережі спортивних гуртків для навчальних закладів, які відповідають інтересам та потребам сучасного молодого покоління.\n" +
//                "Наш гурток має низку переваг: \n" +
//                "- Фізичний розвиток: сприяють загальному фізичному розвитку, зміцнюють здоров'я, розвивають спритність і координацію рухів, виробляють м'язову силу;\n" +
//                "- Психічний розвиток: допомагають виробити силу волі, наполегливість, впевненість у собі, вміння постояти за себе, вміння терпіти біль і втому, долати перешкоди, навички роботи в команді;\n" +
//                "- Додаткові переваги: хороший відпочинок після тривалого сидіння за партою, можливість дитині виплеснути накопичену енергію в конструктивній формі. Спортивні секції можуть бути найрізноманітнішими: хокей, волейбол, баскетбол, футбол, теніс, різні види боротьби, легка атлетика, батут, басейн. Всього і не перерахуєш. У кожного виду спорту своя специфіка. \n" +
//                "Вибір лише за вами, батьки....").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
//        //TUA-178
//        softAssert.assertTrue(addClubModal.enterClubDescription("ё ы э ъ").isErrorMessageDisplayed("Опис гуртка не може містити російські літери"));
//        //TUA-172
//        softAssert.assertTrue(addClubModal.enterClubDescription("s".repeat(1000)).successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.enterClubDescription("s".repeat(40)).successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.enterClubDescription("s".repeat(1500)).successMessageDisplayed());
//        //TUA-173
//        softAssert.assertTrue(addClubModal.enterClubDescription("'Education', 'students', 'Школа' 'балету'").successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.enterClubDescription("1234567890123456789012345678901234567890").successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.enterClubDescription("!#$%&'()*+,-./:;<=>?@[]^_`{}~%^$#)&&^^(_&($%^#@!").successMessageDisplayed());
//        softAssert.assertTrue(addClubModal.completeButtonEnabled());
//        softAssert.assertAll();
//    }
//
//    @Description("Checking that club is created and after find information about it in website and data base")
//    @Test
//    public void creatingClubAndFindingInformationAboutIt() {
//        String randomName = RandomStringUtils.random(7, 'S','p','e','a','k', 'U','A');
//        String numberPhone = "+380934444444";
//        String descriptionOfCenter = "Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.";
//        String checkingInformationAboutCenterByNumber = new HomePage(driver)
//                .openUserProfileMenu()
//                .openAddClubModal()
//                .enterNameClub(randomName)
//                .selectCategoryByName("Спортивні секції")
//                .enterFromAge("8")
//                .enterToAge("16")
//                .enterBelongingToCenter("Курси програмування IT-stat")
//                .clickNextStep()
//                .enterPhoneNumber("0934444444")
//                .clickNextStep()
//                .enterClubDescription(descriptionOfCenter)
//                .finishAddingCenter()
//                .openUserProfileMenu()
//                .openMyProfileModal()
//                .clickLastElementOfTheListOfCenters()
//                .getClubsPage()
//                .getCardByName(randomName)
//                .getDetailInformation()
//                .getNumberPhone();
//        Assert.assertEquals(checkingInformationAboutCenterByNumber, numberPhone);
//        String checkingInformationAboutCenterByDescription = new ClubPage(driver).getDescriptionAboutCenter();
//        Assert.assertEquals(checkingInformationAboutCenterByDescription, descriptionOfCenter);
//        ClubsService service = new ClubsService();
//        ClubsEntity club = service.getByName(randomName);
//        Assert.assertNotNull(club);
//        Assert.assertEquals(club.getName(), randomName);
//    }
//
//    @Description("Checking that club is edited and after find information about it")
//    @Test
//    public void verifyEditingClubAndFindingInformationAboutItTest() {
//        String description = "Тестовий гурток для додавання центру Тестовий гурток для додавання центру";
//        String skype ="speakUA";
//        String nameOfCard = new HomePage(driver)
//                .openUserProfileMenu()
//                .openMyProfileModal()
//                .clickLastElementOfTheListOfCenters()
//                .getClubsPage()
//                .getLastCard()
//                .openEditClubModel()
//                .nextStepClick()
//                .enterLoginOfSkype(skype)
//                .nextStepClick()
//                .enterClubDescription(description)
//                .clickTheEnd()
//                .clickLastElementOfTheListOfCenters()
//                .getClubsPage()
//                .getLastCard()
//                .getTitleInMyProfile();
//        new MyProfilePage(driver)
//                .getClubsPage()
//                .getLastCard()
//                .getDetailInformation();
//        String checkInformationAboutCenterBySkype = new ClubPage(driver)
//                .getLoginOfSkype();
//        Assert.assertEquals(checkInformationAboutCenterBySkype, skype);
//        String checkInformationAboutCenterByDescription = new ClubPage(driver).getDescriptionAboutCenter();
//        Assert.assertEquals(checkInformationAboutCenterByDescription, description);
//        ClubsService service = new ClubsService();
//        ClubsEntity club = service.getByName(nameOfCard);
//        Assert.assertTrue(club.getDescription().contains(description));
//        Assert.assertTrue(club.getContacts().contains(skype));
//        Assert.assertNotNull(club);
//        Assert.assertEquals(club.getName(), nameOfCard);
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}


