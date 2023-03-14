package com.org.api;

import com.org.api.clients.SignInClient;
import com.org.api.models.SingInRequest;
import com.org.api.models.SingInResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInTest {

    @Test
    public void successSingIn() {
        SignInClient client = new SignInClient();
        SingInRequest credential = new SingInRequest("admin", "password123");
        SingInResponse response = client.post(credential);
        Assert.assertNotNull(response.getToken());
        System.out.println(response.getToken());
    }
}
