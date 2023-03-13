package com.org.api.models.club;


import lombok.Data;

import java.util.List;

@Data
public class Category {
    private int id;
    private int sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;

    private List<Club> clubs;

}
