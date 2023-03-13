package com.org.api;

import com.ita.edu.speakua.api.clients.ChallengeClient;
import com.ita.edu.speakua.api.clients.SignInClient;
import com.ita.edu.speakua.api.models.*;
import com.ita.edu.speakua.utils.ConfigProperties;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewChallenge {
    protected static final ConfigProperties configProperties = new ConfigProperties();
    private ChallengeClient client;

    @Description("TUA-437 - Verify that user with any rights can view info about specific Challenge")
    @Test
    public void userViewChallenge() {
        SignInClient clientSI = new SignInClient();
        SingInRequest credentialUser = new SingInRequest(configProperties.getUserEmail(), configProperties.getUserPassword());
        SingInResponse responseUserSI = clientSI.post(credentialUser);
        client = new ChallengeClient(responseUserSI.getAccessToken());
        Response responseUser = client.getById(212);
        Assert.assertEquals(responseUser.getStatusCode(), 200);

        SingInRequest credentialAdmin = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
        SingInResponse responseAdminSI = clientSI.post(credentialAdmin);
        client = new ChallengeClient(responseAdminSI.getAccessToken());
        Response responseAdmin = client.getById(212);
        Assert.assertEquals(responseAdmin.getStatusCode(), 200);
    }
}
