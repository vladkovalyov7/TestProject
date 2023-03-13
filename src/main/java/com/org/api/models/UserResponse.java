package com.org.api.models;

import lombok.Data;

@Data
public class UserResponse {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String roleName;
    private String urlLogo;
    private String status;
}
