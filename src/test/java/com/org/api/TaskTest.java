package com.org.api;

import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.clients.TaskClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class TaskTest {
    protected static final ConfigProperties configProperties = new ConfigProperties();


    private TaskClient client;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseSI = clientSI.post(credential);
        client = new TaskClient(responseSI.getAccessToken());
    }

    @Description("Task cannot be added with null fields")
    @Test
    public void unSucceedTaskAdding(){
        TaskRequest requestBody = new TaskRequest("","stringstringstringstringstringstringstri","","/upload/test/test.png","[2021-11-03]",32);
        ErrorResponse response = client.unSucceedPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("startDate дата має бути в майбутньому and name must contain a minimum of 5 and a maximum of 100 letters" +
                        " and headerText must not be blank and name must not be blank and description must contain a minimum of 40 and a maximum of 3000 letters" +
                "name must not be blank and name must contain a minimum of 5 and a maximum of 100 letters and description must contain a minimum of 40 and a maximum of 3000"+ " letters and headerText must not be blank and startDate дата має бути в майбутньому" +
                "headerText must not be blank and description must contain a minimum of 40 and a maximum of 3000 letters and startDate дата має бути в майбутньому and name must contain " +
                "a minimum of 5 and a maximum of 100 letters and name must not be blank"));

      TaskRequest task = requestBody.toBuilder().build();
       task.setName("namenamena");
       task.setDescription("descriptiondescriptiondescriptiondescriptiondescription");
        response = client.unSucceedPost(task);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("headerText must not be blank and startDate дата має бути в майбутньому"));

        task = requestBody.toBuilder().build();
       task.setName(null);
       task.setDescription(null);
        response = client.unSucceedPost(task);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("name must not be blank and startDate дата має бути в майбутньому and headerText must not be blank"));
        softAssert.assertAll();
    }

    @Description(" Verify that user can edit Task with valid values")
    @Test
    public void editTaskSuccessful(){
        TaskRequest requestBody = new TaskRequest("namenamename1213#$%",
                "stringstringstringstringstringstringstri",
                "descriptiondescriptiondescriptiondescriptiondescription12345$%%^$#",
                "/upload/test/test.png",
                "2021-12-03",
                32);
        TaskResponse response = client.successfulEditTask(requestBody);
        List<Integer> startDate = new ArrayList<Integer>(){{
            add(2021);
            add(12);
            add(3);
        }};
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getId(),202);
        softAssert.assertEquals(response.getName(),"namenamename1213#$%");
        softAssert.assertEquals(response.getHeaderText(),"stringstringstringstringstringstringstri");
        softAssert.assertEquals(response.getDescription(),"descriptiondescriptiondescriptiondescriptiondescription12345$%%^$#");
        softAssert.assertEquals(response.getPicture(),"/upload/test/test.png");
        softAssert.assertEquals(response.getStartDate(), startDate);
        softAssert.assertEquals(response.getChallengeId(),32);
        softAssert.assertAll();
    }

    @Description("Task cannot be editing with invalid values")
    @Test
    public void editTaskUnSuccessful(){
        TaskRequest requestBody = new TaskRequest("namename",
                "stringstringstringstringstringstringstri",
                "descriptiondescriptiondescriptiondescri",
                "/upload/test/test.png",
                "2021-12-03",
                0);
        ErrorResponse response = client.unsuccessfulPutTask(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("name must contain a minimum of 5 and a maximum of 100 letters"));

        requestBody = new TaskRequest("namenamename",
                "stringst",
                "descriptiondescriptiondescriptiondescri",
                "/upload/test/test.png",
                "2021-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("headerText must contain a minimum of 40 and a maximum of 10000 letters"));

        requestBody = new TaskRequest("namenamename",
                "descriptiondescriptiondescriptiondescriptiondescription Ё, Ы,Э",
                "descriptiondescriptiondescriptiondescriptiondescriptio",
                "/upload/test/test.png",
                "2021-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("headerText Помилка. Текст містить недопустимі символи"));
        softAssert.assertAll();
    }

    @Description("Verifying that user can not create Task with invalid values")
    @Test
    public void createTaskInvalidValues(){
        TaskRequest requestBody = new TaskRequest("name",
                "stringstringstringstringstringstringstri",
                "descriptiondescriptiondescriptiondescriptiondescription",
                "/upload/test/test.png",
                "2023-12-03",
                0);
        ErrorResponse response = client.unSucceedPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertEquals(response.getMessage(), "name must contain a minimum of 5 and a maximum of 100 letters", "4");

        requestBody = new TaskRequest("namenamenamenamenamenamenamenamenamenaamenamenamenamenanamenamenamenamenamenamenamenamenamenaamenamenm",
                "stringst",
                "descriptiondescriptiondescriptiondescriptiondescription",
                "/upload/test/test.png",
                "2023-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("name must contain a minimum of 5 and a maximum of 30 letters"));

        requestBody = new TaskRequest("namenameЁ, Ы,Э",
                "descriptiondescriptiondescriptiondescriptiondescription",
                "descriptiondescriptiondescriptiondescriptiondescriptio",
                "/upload/test/test.png",
                "2023-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertTrue(response.getMessage().contains("name Помилка. Текст містить недопустимі символи"));
//
        requestBody = new TaskRequest("namename",
                "description",
                "test",
                "/upload/test/test.png",
                "2023-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("description must contain a minimum of 40 and a maximum of 3000 letters"));

        requestBody = new TaskRequest("namename",
                "description",
                "descriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondedescriptiondescriptiondescridescriptionde",
                "/upload/test/test.png",
                "2023-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertFalse(response.getMessage().contains("description must contain a minimum of 40 and a maximum of 3000 letters"));

        requestBody = new TaskRequest("namename",
                "description",
                "descriptionЁЁЁЁЫdescriptionЁЁЁЁЫdescriptionЁЁЁЁЫ",
                "/upload/test/test.png",
                "2023-12-03",
                0);
        response = client.unsuccessfulPutTask(requestBody);
        softAssert.assertEquals(response.getStatus(),400);
        softAssert.assertTrue(response.getMessage().contains("description Помилка. Текст містить недопустимі символи"));
        softAssert.assertAll();
    }

    @Description("TUA-446 - Verify that user can not edit Task using null, spaces as values")
    @Test
    public void verifyThatUserCannotEditTaskUsingNullOrSpacesAsValues(){
        TaskRequest requestBodySpaces = new TaskRequest(" ",
                " ",
                " ",
                "/upload/test/test.png",
                "2021-11-03",
                0);
        ErrorResponse responseSpaces = client.unsuccessfulPutTask(requestBodySpaces);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseSpaces.getStatus(),400);
        softAssert.assertFalse(responseSpaces.getMessage().contains("name must contain a minimum of 5 and a maximum of 255 letters and headerText must not be blank and name must not be blank and headerText must contain a minimum of 40 and a maximum of 10000 letters"));

        TaskRequest requestBodyNull = new TaskRequest(null,
                null,
                null,
                "/upload/test/test.png",
                "2021-11-03",
                0);
        ErrorResponse responseNull = client.unsuccessfulPutTask(requestBodyNull);
        softAssert.assertEquals(responseNull.getStatus(),400);
        softAssert.assertFalse(responseNull.getMessage().contains("name must not be blank and headerText must not be blank"));
        softAssert.assertAll();
    }

    @Description("Verify that user can create Task with valid values")
    @Test
    public void creatingTaskWithValidData(){
        TaskPostRequest requestBody = new TaskPostRequest("namenamename1213#$%",
                "stringstr",
                "descriptiondescriptiondescriptiondescriptiondescription12345$%%^$#",
                "/upload/test/test.png",
                "2025-12-03");
        TaskPostResponse response = client.successfulCreatedTask(requestBody,514);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getId() , 512);
        softAssert.assertEquals(response.getStatus(), 200);
    }

}
