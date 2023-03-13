package com.org.api.models;

import lombok.Data;

@Data
public class ChallengePostResponse {
    private int id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private int sortNumber;
    private Boolean isActive;
    private UserChallenge user;

}


