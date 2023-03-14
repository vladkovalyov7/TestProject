package com.org.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingInRequest {
    String username;
    String password;
}
