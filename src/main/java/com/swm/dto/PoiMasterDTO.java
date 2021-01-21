package com.swm.dto;


import lombok.Data;

@Data
public class PoiMasterDTO {

    private Long poi_id;
    private String ward_name;
    private String holding_no;
    private String usage_type;
    private String property_type;
    private String plot_no;
    private String owner_name;
    private String guardian_name;
    private String mobile_no;
    private  String property_address;
    private String city;
    private int pin;
    private float latitude;
    private float longitude;

}
