package com.org.api;
//
//import com.ita.edu.speakua.api.clients.SignInClient;
//import com.ita.edu.speakua.api.models.SingInRequest;
//import com.ita.edu.speakua.api.models.SingInResponse;
//import com.ita.edu.speakua.utils.ConfigProperties;
//import io.qameta.allure.Description;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//public class LoginTest {
//    protected static final ConfigProperties configProperties = new ConfigProperties();
//    @Description("success SingIn")
//    @Test
//    public void successSingIn() {
//        SignInClient client = new SignInClient();
//        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
//        SingInResponse response = client.post(credential);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getId(), 1);
//        softAssert.assertEquals(response.getRoleName(), "ROLE_ADMIN");
//        softAssert.assertEquals(response.getEmail(), configProperties.getAdminEmail());
//        softAssert.assertNotNull(response.getAccessToken());
//        System.out.println(response.getAccessToken());
//        softAssert.assertAll();
//    }
//
//    @Description("success SingIn")
//    @Test
//    public void successSingInManager() {
//        SignInClient client = new SignInClient();
//        SingInRequest credential = new SingInRequest(configProperties.getUserSoyecEmail(), configProperties.getUserSoyecPassword());
//        SingInResponse response = client.post(credential);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getId(), 203);
//        softAssert.assertEquals(response.getRoleName(), "ROLE_MANAGER");
//        softAssert.assertEquals(response.getEmail(), configProperties.getUserSoyecEmail());
//        softAssert.assertNotNull(response.getAccessToken());
//        System.out.println(response.getAccessToken());
//        softAssert.assertAll();
//    }
//}
