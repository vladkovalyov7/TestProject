package com.org.api.clients;

import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.club.ClubPostRequest;
import io.restassured.response.Response;

public class ClubClient extends BaseClient {
    private String token;
    public ClubClient() {
        super();
    }

    public ClubClient(String token) {
        super();
        this.token = token;
    }

    public Response successPost(ClubPostRequest request) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl + "/api/club");
    }

    public ErrorResponse badPost(ClubPostRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(baseUrl + "/api/club")
                .as(ErrorResponse.class);
    }

}

