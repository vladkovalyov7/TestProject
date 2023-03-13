package com.org.api.clients;

import com.ita.edu.speakua.api.models.ErrorResponse;
import com.ita.edu.speakua.api.models.UserRequest;
import com.ita.edu.speakua.api.models.UserResponse;
import io.restassured.response.Response;
public class UserClient extends BaseClient{
    private final String token;
    public UserClient(String token){
        super();
        this.token = token;}

    public ErrorResponse badPut(UserRequest response){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(response)
                .when()
                .put("/api/user/203")
                .as(ErrorResponse.class);
    }

    public UserResponse successfulChanges(UserRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/user/1")
                .as(UserResponse.class);

    }
    public Response put(UserRequest request, int id) {
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/user/" + id);
    }

    public UserResponse successfulPutChanges(UserRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/user/203")
                .as(UserResponse.class);

    }
}
