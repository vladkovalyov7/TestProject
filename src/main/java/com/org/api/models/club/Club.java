package com.org.api.models.club;

import lombok.Data;

import java.util.List;

@Data
public class Club {
    private int id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<String> urlGallery;
    private String workTime;
    private Integer rating;
    private Integer feedbackCount;
    private List<String> locations;
    private List<String> categories;
    private User user;
    private String center;
    private Integer isApproved;
    private Boolean isOnline;
    private String contacts;
    private Integer clubExternalId;
    private Integer centerExternalId;
}
