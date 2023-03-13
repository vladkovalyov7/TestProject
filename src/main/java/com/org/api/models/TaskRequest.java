package com.org.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class TaskRequest {
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private int challengeId;
}
