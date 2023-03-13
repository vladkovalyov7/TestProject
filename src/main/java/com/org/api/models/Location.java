package com.org.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class Location {
    private int id = 0;
    private String name;
    private String address;
    private int cityId = 0;
    private int districtId = 0;
    private int stationId = 0;
    private String cityName;
    private String districtName;
    private String stationName;
    private String coordinates;
    private int longitude = 0;
    private int latitude = 0;
    private int centerId = 0;
    private int clubId = 0;
    private String phone;
}