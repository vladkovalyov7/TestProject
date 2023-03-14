package com.org.api;

import com.org.api.clients.SignInClient;
import com.org.api.clients.UserClient;
import com.org.api.models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//
//public class UserTest {
//    protected static final ConfigProperties configProperties = new ConfigProperties();
//
//    private UserClient client;
//
//    @BeforeClass
//    public void beforeClass() {
//        SignInClient clientSI = new SignInClient();
//        SingInRequest credential = new SingInRequest(configProperties.getAdminEmail(), configProperties.getAdminPassword());
//        SingInResponse responseSI = clientSI.post(credential);
//        client = new UserClient(responseSI.getAccessToken());
//    }
//    @Description("User with invalid data cannot save changes")
//    @Test
//    public void invalidNameRequest(){
//        UserRequest requestBody = new UserRequest(203,
//                "soyec48727@busantei.com",
//                "Nastia1234",
//                "Kukh",
//                "999999922",
//                "ROLE_MANAGER",
//                "",
//                true);
//        ErrorResponse response = client.badPut(requestBody);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getStatus(),400);
//        softAssert.assertEquals(response.getMessage(),"\"firstName\" can`t contain numbers");
//
//        UserRequest user = requestBody.toBuilder().build();
//        user.setFirstName("NastiaNastiaNastiaNastiaNastia");
//        response = client.badPut(user);
//        softAssert.assertEquals(response.getStatus(),400);
//        softAssert.assertEquals(response.getMessage(),"\"firstName\" can contain from 1 to 25 letters");
//
//        user = requestBody.toBuilder().build();
//        user.setFirstName("Nastia!@##$#$%");
//        response = client.badPut(user);
//        softAssert.assertEquals(response.getStatus(),400);
//        softAssert.assertEquals(response.getMessage(),"\"firstName\" can contain only ukrainian and english letters");
//
//        user = requestBody.toBuilder().build();
//        user.setLastName("Kukhar#%$#");
//        response = client.badPut(user);
//        softAssert.assertEquals(response.getStatus(),400);
//        softAssert.assertEquals(response.getMessage(),"\"lastName\" can contain only ukrainian and english letters");
//
//        user = requestBody.toBuilder().build();
//        user.setLastName("KukharKukharKukharKukharKukharKukharKukhar#");
//        response = client.badPut(user);
//        softAssert.assertEquals(response.getStatus(),400);
//        softAssert.assertEquals(response.getMessage(),"\"lastName\" can contain from 1 to 25 letters");
//
//        user = requestBody.toBuilder().build();
//        user.setLastName("Kukhar123343#");
//        response = client.badPut(user);
//        softAssert.assertEquals(response.getStatus(),400);
//        softAssert.assertEquals(response.getMessage(),"\"lastName\" can`t contain numbers");
//        softAssert.assertAll();
//
//    }
//
//    @Description("The user or manager can change their role")
//    @Test
//    public void successUserChanges(){
//        UserRequest requestBody = new UserRequest(1,
//                "admin@gmail.com",
//                "Admin",
//                "Admin",
//                "0689543242",
//                "ROLE_MANAGER",
//                null,
//                true);
//        UserResponse response = client.successfulChanges(requestBody);
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(response.getId(),1);
//        softAssert.assertEquals(response.getEmail(),"admin@gmail.com");
//        softAssert.assertEquals(response.getFirstName(),"Admin");
//        softAssert.assertEquals(response.getLastName(),"Admin");
//        softAssert.assertEquals(response.getPhone(),"0689543242");
//        softAssert.assertEquals(response.getRoleName(),"ROLE_MANAGER");
//
//        UserRequest user = requestBody.toBuilder().build();
//        user.setRoleName("ROLE_USER");
//        response = client.successfulChanges(user);
//        softAssert.assertEquals(response.getRoleName(),"ROLE_USER");
//
//        user = requestBody.toBuilder().build();
//        user.setRoleName("ROLE_ADMIN");
//        response = client.successfulChanges(user);
//        softAssert.assertEquals(response.getRoleName(),"ROLE_ADMIN");
//softAssert.assertAll();
//
//    }
//}
