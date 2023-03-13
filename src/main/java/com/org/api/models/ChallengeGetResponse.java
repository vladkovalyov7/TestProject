package com.org.api.models;

import lombok.Data;

import java.util.List;

@Data
public class ChallengeGetResponse {
    private int id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private int sortNumber;
    private Boolean isActive;
    private List<String> tasks;
    private UserChallenge user;
}
