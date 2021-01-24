package com.swm.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PoiMasterDTO {

    private Long poi_id;
    private String ward_id;
    private String holding_no;
    private String usage_type;
    private String property_type;
    private String plot_no;
    private String owner_name;
    private String guardian_name;
    private String mobile_number;
    private  String property_address;
    private String city;
    private int pin;
    private float latitude;
    private float longitude;

}
