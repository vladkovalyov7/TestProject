package com.org.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class UserRequest {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String roleName;
    private String urlLogo;
    private Boolean status;
}

