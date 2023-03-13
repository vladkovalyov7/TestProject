package com.org.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpPostRequest {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String roleName;
    private String verificationCode;
    private String urlLogo;
    private String status;
}
