package com.org.api.models;

import lombok.Data;

@Data
public class SignUpPostResponse {
    private int id;
    private String email;
    private String roleName;
}
