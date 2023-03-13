package com.org.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClubPostRequest {
    private String name;
    private String description;
    private int centerId;
    private List<String> categoriesName;
    private List<Location> locations;
    private int ageFrom;
    private int ageTo;
    private String urlBackground;
    private String urlLogo;
    private boolean isOnline;
    private String contacts;
    private int userId;
}
