package com.org.api.models;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
public class TaskResponse {
    private int id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private List<Integer> startDate;
    private int challengeId;
}
