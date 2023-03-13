package com.org.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Jacksonized
public class ChallengePutRequest {
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private String sortNumber;
    @JsonProperty("isActive")
    private boolean isActive;
}
