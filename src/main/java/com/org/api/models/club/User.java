package com.org.api.models.club;

import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private String role;
    private String provider;
    private String providerId;
    private Boolean status;
    private String verificationCode;
}

