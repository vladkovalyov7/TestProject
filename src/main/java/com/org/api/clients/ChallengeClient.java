package com.org.api.clients;

import com.github.dockerjava.api.model.ErrorResponse;
import io.restassured.response.Response;

//public class ChallengeClient extends BaseClient {
//    private String token;
//    public ChallengeClient(){
//        super();
//    }
//    public ChallengeClient(String token){
//        super();
//        this.token = token;
//    }
//
//    public PerformAuthPostResponse successPost(PerformAuthPostRequest request){
//        return prepareRequest()
//                .header("Authorization", "Bearer " + token)
//                .body(request)
//                .when()
//                .post("/api/challenge")
//                .as(ChallengePostResponse.class);
//
//    }
//    public ErrorResponse unsuccessfulPut(ChallengePutRequest request, int idChallenge){
//        return prepareRequest()
//                .header("Authorization", "Bearer " + token)
//                .body(request)
//                .when()
//                .put("/api/challenge/" +idChallenge)
//                .as(ErrorResponse.class);
//    }
//
//
//    public Response delete(int idChallenge) {
//        return prepareRequest()
//                .header("Authorization", "Bearer " + token)
//                .when()
//                .delete("/api/challenge/" +idChallenge );
//    }
//
//    public ChallengePutResponse successPut(ChallengePutRequest request, int idChallenge){
//        return prepareRequest()
//                .header("Authorization", "Bearer " + token)
//                .body(request)
//                .when()
//                .put("/api/challenge/" +idChallenge)
//                .as(ChallengePutResponse.class);
//    }
//
//    public Response getById(int idChallenge){
//        return prepareRequest()
//                .header("Authorization", "Bearer " + token)
//                .when()
//                .get("/api/challenge/" +idChallenge);
//    }
//}
