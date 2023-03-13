package com.org.api.models.club;


import lombok.Data;

import java.util.List;

@Data
public class ClubPostResponse {
    private int id;
    private int ageFrom;
    private int ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private String urlGallery;
    private String workTime;
    private List<Category> categories;
    private User user;
    private Center center;
    private int rating;
    private List<LocationResponse> locations;
    private Boolean isApproved;
    private Boolean isOnline;
}


