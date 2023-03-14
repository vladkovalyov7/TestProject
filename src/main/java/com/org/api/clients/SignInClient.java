package com.org.api.clients;
//
//import com.ita.edu.speakua.api.models.SingInRequest;
//import com.ita.edu.speakua.api.models.SingInResponse;
//import io.restassured.response.Response;
//
//public class SignInClient extends BaseClient{
//    public SignInClient() {
//        super();
//    }
//    public SingInResponse post(SingInRequest credential) {
//        Response response =  prepareRequest()
//                .body(credential)
//                .when()
//                .post(baseUrl+"/api/signin");
//        SingInResponse singInResponse = response.as(SingInResponse.class);
//        return singInResponse;
//    }
//
//}
