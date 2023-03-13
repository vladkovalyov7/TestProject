package com.org.api;

import com.ita.edu.speakua.api.clients.ChallengeClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.jdbc.services.ChallengesService;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengeTest {
    protected static final ConfigProperties configProperties = new ConfigProperties();
    private ChallengeClient client;
    private ChallengeClient clientUser;

    @BeforeClass
    public void beforeClass() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseSI = clientSI.post(credential);
        client = new ChallengeClient(responseSI.getAccessToken());

    }

    @Description("success SingIn")
    @Test
    public void badPost1() {
        ChallengeClient client = new ChallengeClient();
        ChallengePostRequest requestBody = new ChallengePostRequest("name123",
                "title",
                "descriptiondescriptiondescriptiondescriptiondescription",
                "https://docs.google.com/forms/d/e/145/viewform?embedded=true",
                "/upload/1/1.png",
                0);
        ErrorResponse response = client.badPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 401);
        softAssert.assertEquals(response.getMessage(), "You have no necessary permissions (role)");
        softAssert.assertAll();
    }

    @Description("TUA-429 - Verify that user is able to create Challenge using valid values")
    @Test
    public void createChallenge() {
        ChallengesService service = new ChallengesService();
        int sortNumber = service.getUniqueNumber();
        ChallengePostRequest requestBody = new ChallengePostRequest("name1",
                "title",
                "stringstringstringstringstringstringstri",
                "https://docs.google.com/forms/d/e/145/viewform?embedded=true",
                "/upload/1/1.png",
                sortNumber);
        ChallengePostResponse response = client.successPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getDescription(), requestBody.getDescription());
        softAssert.assertEquals(response.getSortNumber(), sortNumber);
        softAssert.assertEquals(response.getUser().getFirstName(), "Admin");
        softAssert.assertAll();
    }

    @Description("Edit Challenge with invalid data")
    @Test
    public void invalidChallengeEdit() {
        ChallengePutRequest requestBody = new ChallengePutRequest("nam",
                "tit",
                "des",
                null,
                "abc",
                "abc",
                true);
        ErrorResponse response = client.unsuccessfulPut(requestBody, 236);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertTrue(response.getMessage().contains("JSON parse error: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value\n" +
                " at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 102] (through reference chain: com.softserve.teachua.dto.challenge.UpdateChallenge[\"sortNumber\"])"));

        requestBody = new ChallengePutRequest("Lorem ipsum dolor sit amet, consect",
                "Lorem ipsum dolor sit amet, consect",
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eu",
                null,
                "abc",
                "abc",
                true);
        response = client.unsuccessfulPut(requestBody, 236);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertTrue(response.getMessage().contains("JSON parse error: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `long` from String \"abc\": not a valid `long` value\n" +
                " at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 3168] (through reference chain: com.softserve.teachua.dto.challenge.UpdateChallenge[\"sortNumber\"])"));

        requestBody = new ChallengePutRequest("эЭъЪыЫёЁ",
                "эЭъЪыЫёЁ",
                "эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ",
                null,
                "эЭъЪыЫёЁ",
                "эЭъЪыЫёЁ",
                true);
        response = client.unsuccessfulPut(requestBody, 236);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertTrue(response.getMessage().contains("JSON parse error: Cannot deserialize value of type `long` from String \"эЭъЪыЫёЁ\": not a valid `long` value; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `long` from String \"эЭъЪыЫёЁ\": not a valid `long` value\n" +
                " at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 218] (through reference chain: com.softserve.teachua.dto.challenge.UpdateChallenge[\"sortNumber\"])"));
        softAssert.assertAll();
    }

    @Description("Edit Challenge with valid data")
    @Test
    public void validChallengeEdit() {
        int idOfChallenge = 359;
        ChallengePutRequest requestBody = new ChallengePutRequest("Example name",
                "Example title",
                "Lorem ipsum dolor sit amet, consectetuer adipiscin",
                "https://docs.google.com/forms/d/e/236/viewform?embedded=true",
                "/upload/test/test.png",
                "1",
                true);
        ChallengePutResponse response = client.successPut(requestBody, idOfChallenge);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getId(), idOfChallenge);
        softAssert.assertEquals(response.getName(), "Example name");
        softAssert.assertEquals(response.getDescription(), "Lorem ipsum dolor sit amet, consectetuer adipiscin");
        softAssert.assertAll();
    }

    @Description("User is not able to edit information using null, spaces or absence of symbols")
    @Test
    public void challengeWithNullValues() {
        ChallengePutRequest requestBody = new ChallengePutRequest(null,
                null,
                null,
                null,
                null,
                null,
                true);
        ErrorResponse response = client.unsuccessfulPut(requestBody, 236);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertFalse(response.getMessage().contains("description must not be blank and sortNumber must not be null and picture must not be blank and name must not be blank and title must not be blank"));

        requestBody = new ChallengePutRequest(
                " ",
                " ",
                " ",
                null,
                " ",
                " ",
                true);
        response = client.unsuccessfulPut(requestBody, 236);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertFalse(response.getMessage().contains("description must contain a minimum of 40 and a maximum of 25000 letters and picture Incorrect file path." +
                " It must be like /upload/*/*.png and sortNumber must not be null and picture " +
                "must not be blank and description must not be blank and title must not be blank and name Name must contain " +
                "a minimum of 5 and a maximum of 30 letters and name must not be blank and title must contain a minimum of 5 and a maximum of 100 letters"));
        requestBody = new ChallengePutRequest(
                "",
                "",
                "",
                null,
                "",
                "",
                true);
        response = client.unsuccessfulPut(requestBody, 236);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertFalse(response.getMessage().contains("description must contain a minimum of 40 and a maximum of 25000 letters and picture Incorrect file path." +
                " It must be like /upload/*/*.png and sortNumber must not be null and picture " +
                "must not be blank and description must not be blank and title must not be blank and name Name must contain " +
                "a minimum of 5 and a maximum of 30 letters and name must not be blank and title must contain a minimum of 5 and a maximum of 100 letters"));
        softAssert.assertAll();
    }

    @Description("success create and delete Challenge")
    @Test
    public void SuccessCreateAndDeleteChallenge() {
        ChallengePostRequest requestBody = new ChallengePostRequest("name for delete",
                "title for delete",
                "stringstringstringstringstringstringstri",
                "https://docs.google.com/forms/d/e/145/viewform?embedded=true",
                "/upload/1/1.png", 6861);
        ChallengePostResponse response = client.successPost(requestBody);
        int idChallenge = response.getId();
        Response responseDel = client.delete(idChallenge);
        Assert.assertEquals(responseDel.statusCode(), 200);
    }

    @Description("Verify that user is not able to create Challenge using null, spaces or absence of symbols as values")
    @Test
    public void InabilityCreateChallengeWithInappropriateSymbols() {
        ChallengePostRequest requestBody = new ChallengePostRequest(null,
                null,
                null,
                "https://docs.google.com/forms/d/e/236/viewform?embedded=true",
                null,
                null);
        ErrorResponse response = client.badPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertFalse(response.getMessage().contains("picture must not be blank and title must not be blank and " +
                "name must not be blank and description must not be blank and sortNumber must not be null"));

        requestBody = new ChallengePostRequest(" ",
                " ",
                " ",
                "https://docs.google.com/forms/d/e/236/viewform?embedded=true",
                " ",
                0);
        response = client.badPost(requestBody);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertFalse(response.getMessage().contains("picture Incorrect file path. It must be like /upload/*/*.png and title не може бути пустим " +
                "and description не може бути пустим and title must contain a minimum of 5 and a maximum of 100 letters and name  must contain a minimum of 5 and a maximum of 30 letters " +
                "and picture не може бути пустим and description must contain a maximum of 25000 letters and name не може бути пустим"));

        requestBody = new ChallengePostRequest("",
                "",
                "",
                "https://docs.google.com/forms/d/e/236/viewform?embedded=true",
                "",
                0);
        response = client.badPost(requestBody);
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertFalse(response.getMessage().contains("name  must contain a minimum of 5 and a maximum of 30 letters and title не може бути пустим " +
                "and picture не може бути пустим and description must contain a maximum of 25000 letters and description не може бути пустим and picture Incorrect file path. It must be like /upload/*/*.png " +
                "and name не може бути пустим and title must contain a minimum of 5 and a maximum of 100 letters"));
        softAssert.assertAll();
    }

}
