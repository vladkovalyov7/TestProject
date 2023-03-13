package com.org.ui;

import com.ita.edu.speakua.jdbc.entity.TasksEntity;
import com.ita.edu.speakua.jdbc.services.TasksService;
import com.ita.edu.speakua.ui.Pages.TaskPO.AddTaskPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TaskTests extends BaseTestRunner {
    String taskName =  RandomStringUtils.random(10, true, true);
    String taskTitle = RandomStringUtils.random(60, true, true);
    String taskDescription = RandomStringUtils.random(50, true, true);
    String imagepath = "\\src\\test\\resources\\R.jpeg";

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


    @Description("Add Task Without Challenge")
    @Test
    public void addTaskWithoutChallenge() {
        AddTaskPage enterTaskData = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterTaskData.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterTaskData.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterTaskData.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterTaskData.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterTaskData.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2021-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .clickSave();
        softAssert.assertTrue(enterTaskData.isContainErrorMessage("Please,select challenge"));
        softAssert.assertAll();
        TasksService service = new TasksService();
        TasksEntity task = service.getByName(taskName);
        Assert.assertNull(task);
    }

    @Description("Add Task with Invalid Description")
    @Test
    public void taskWithInvalidDescription() {
        AddTaskPage enterInvalidData = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidData.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidData.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidData.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidData.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidData.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("Поле опис не може бути пустим"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterTaskDescription("ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð")
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("Поле 'Опис' може містити тільки українські та англійські літери, цифри та спеціальні символи"));
        softAssert = new SoftAssert();
        String taskDescriptionLess = RandomStringUtils.random(30, true, true);
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescriptionLess)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("Поле 'Опис' може містити мінімум 40 максимум 3000 символів"));
        softAssert = new SoftAssert();
        String taskDescriptionMore =  RandomStringUtils.random(3005, true, true);
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescriptionMore)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidData.isContainErrorMessage("Поле 'Опис' може містити мінімум 40 максимум 3000 символів"));
        softAssert.assertAll();
        TasksService service = new TasksService();
        TasksEntity task = service.getByName(taskName);
        Assert.assertNotEquals(task.getId(),1061);

    }


    @Description("addTaskWithInvalidTitle")
    @Test
    public void addTaskWithInvalidTitle() {
        AddTaskPage enterInvalidTitle = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidTitle.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidTitle.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidTitle.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-01-01")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Заголовок' не може бути пустим"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle("ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð")
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Заголовок' може містити тільки українські та англійські літери, цифри та спеціальні символи"));
        softAssert = new SoftAssert();
        String taskTitle =  RandomStringUtils.random(30, true, true);
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів"));
        softAssert = new SoftAssert();
        String taskTitleMore =  RandomStringUtils.random(3007, true, true);
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitleMore)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів"));
        softAssert.assertAll();
    }

    @Description("Add Task with Invalid Name")
    @Test
    public void addInvalidTaskName() {
        AddTaskPage enterInvalidTitle = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidTitle.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidTitle.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidTitle.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidTitle.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-01-01")
                .uploadImage(imagepath)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Назва' не може бути пустим"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage(imagepath)
                .enterTaskName("ъэы; ผม, Ÿ, ð")
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Назва' може містити тільки українські та англійські літери, цифри та спеціальні символи"));
        softAssert = new SoftAssert();
        String taskName =  RandomStringUtils.random(3, true, true);
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Назва' може містити мінімум 5 максимум 50 символів"));
        softAssert = new SoftAssert();
        String taskNameMore =  RandomStringUtils.random(60, true, true);
        new AddTaskPage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage(imagepath)
                .enterTaskName(taskNameMore)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidTitle.isContainErrorMessage("Поле 'Назва' може містити мінімум 5 максимум 50 символів"));
        softAssert.assertAll();
    }

    @Description("Add task with invalid date")
    @Test
    public void addTaskWithInvalidDate() {
        AddTaskPage enterInvalidDate = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(enterInvalidDate.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(enterInvalidDate.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(enterInvalidDate.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(enterInvalidDate.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(enterInvalidDate.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(enterInvalidDate.isContainErrorMessage("Дата початку не може бути відсутня"));
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2018-03-03")
                .clickSave();
        softAssert.assertTrue(enterInvalidDate.isContainErrorMessage("Дата початку має бути в майбутньому"));
        softAssert.assertAll();
        TasksService service = new TasksService();
        TasksEntity task = service.getByName(taskName);
        Assert.assertNull(task);
    }

    @Description("Add Task Without Image")
    @Test
    public void addTaskWithoutImage() {
        AddTaskPage uploadImage = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(uploadImage.getStartDate().getText(), "", "Start-date field is empty");
        softAssert.assertEquals(uploadImage.getUploadImage().getText(), "", "Image is not uploaded");
        softAssert.assertEquals(uploadImage.getTaskName().getText(), "", "Task name field is empty");
        softAssert.assertEquals(uploadImage.getTaskTitle().getText(), "", "Title for task field is empty");
        softAssert.assertEquals(uploadImage.getTaskDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        new AddTaskPage(driver)
                .enterStartDate("2023-03-03")
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        softAssert.assertTrue(uploadImage.isContainErrorMessage("Фото не може бути пустим"));
        softAssert.assertAll();
        TasksService service = new TasksService();
        TasksEntity task = service.getByName(taskName);
        Assert.assertNull(task);
    }

    @Description("Add Task With Valid Data")
    @Test
    public void addTask() {
        AddTaskPage enterValidData = new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-03-03")
                .uploadImage(imagepath)
                .enterTaskName(taskName)
                .enterTaskTitle(taskTitle)
                .enterTaskDescription(taskDescription)
                .chooseChallenge()
                .clickSave();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(enterValidData.successMessage("Завдання успішно збережене"));
        softAssert.assertAll();

        TasksService service = new TasksService();
        TasksEntity task = service.getByName(taskName);
        Assert.assertNotNull(task);
        Assert.assertEquals(task.getId(),1070);


    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
