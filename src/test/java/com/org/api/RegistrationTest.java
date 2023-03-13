package com.org.api;

import com.ita.edu.speakua.api.clients.SignUpClient;
import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.SignUpPostRequest;
import com.ita.edu.speakua.jdbc.entity.UsersEntity;
import com.ita.edu.speakua.jdbc.services.UsersService;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTest {

    @Description("Verifying that user with invalid data in password field can`t be created")
    @Test
    public void unsuccessfulSingUp() {
        SignUpClient client = new SignUpClient();
        SignUpPostRequest requestBody = new SignUpPostRequest(
                0,
                "example@test.com",
                "firstname",
                "lastname",
                "0123456789",
                "123456",
                "ROLE_MANAGER",
                "verificationCode",
                "urlLogo",
                "status");
        ErrorResponse response = client.unsuccessfulPost(requestBody);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatus(), 400);
        softAssert.assertTrue(response.getMessage().contains("password size must be between 8 and 20"));

        UsersService service = new UsersService();
        UsersEntity user = service.getByEmail("example@test.com");
        softAssert.assertNull(user);
        softAssert.assertAll();
    }
}
