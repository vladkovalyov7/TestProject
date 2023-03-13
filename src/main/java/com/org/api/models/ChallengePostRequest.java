package com.org.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChallengePostRequest {

    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private Integer sortNumber;
}
