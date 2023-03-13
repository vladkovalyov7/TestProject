package com.org.api.clients;

import com.ita.edu.speakua.api.models.*;

import static java.lang.String.format;

public class TaskClient extends BaseClient{
    private final String token;
    public TaskClient(String token){
        super();
    this.token = token;}

    public ErrorResponse unSucceedPost(TaskRequest request){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post("/api/challenge/1/task")
                .as(ErrorResponse.class);
    }
    public TaskResponse successfulEditTask(TaskRequest request){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("api/challenge/task/202")
                .as(TaskResponse.class);
    }

    public ErrorResponse unsuccessfulPutTask(TaskRequest request){
        return prepareRequest()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .put("/api/challenge/207")
                .as(ErrorResponse.class);
    }

    public TaskPostResponse successfulCreatedTask(TaskPostRequest request, int challengeId){
        return prepareRequest()
                .headers("Authorization", "Bearer " + token)
                .body(request)
                .when()
                .post(format(baseUrl+"/api/challenge/%s/task",challengeId))
                .as(TaskPostResponse.class);
    }
}
