package com.org.api;

import com.org.api.clients.SignInClient;
import com.org.api.models.SingInRequest;
import com.org.api.models.SingInResponse;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    @Description("success SingIn")
    @Test
    public void successSingIn() {
        SignInClient client = new SignInClient();
        SingInRequest credential = new SingInRequest("admin", "password123");
        SingInResponse response = client.post(credential);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(response.getToken());
        System.out.println(response.getToken());
        softAssert.assertAll();
    }

}
