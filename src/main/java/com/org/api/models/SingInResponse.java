package com.org.api.models;


import lombok.Data;

@Data
public class SingInResponse {
    private int id;
    private String email;
    private String roleName;
    private String accessToken;
}
