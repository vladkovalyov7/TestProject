package com.org.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChallengePutResponse {
    private int id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private String sortNumber;
    @JsonProperty("isActive")
    private boolean isActive;
}
