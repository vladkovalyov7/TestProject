package com.org.api.models.club;

import lombok.Data;

import java.util.List;

@Data
public class Center {
    private int id;
    private String name;
    private String contacts;
    private String urlBackgroundPicture;
    private String email;
    private String phones;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String socialLinks;
    private List<LocationResponse> locations;
    private List<Club> clubs;
    private User user;
    private Integer centerExternalId;
    private Integer rating;
    private Integer clubCount;
}
