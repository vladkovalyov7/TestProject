package com.org.api.models.club;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Location {
    private int id;
    private String name;
    private String address;
    private String cityName;
    private String districtName;
    private String stationName;
    private LocationCity locationCity;
    private Integer cityId;
    private Integer districtId;
    private Integer stationId;
    private Integer clubId;
    private String coordinates;
    private Integer latitude;
    private Integer longitude;
    private String phone;
    private Double key;
}
