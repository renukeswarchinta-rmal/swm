package com.swm.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swm.entity.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
public class PoiMasterDTO {

    private Long id;
    private WardMaster wardMaster;
    private String holding_no;
    private PropertyTypeMaster property_type;
    private PropertyUsageTypeMaster propertyUsageTypeMaster;
    private String plot_no;
    private String owner_name;
    private String guardian_name;
    private String mobile_number;
    private  String property_address;
    private City city;
    private PinCode pinCode;
    private float latitude;
    private float longitude;
    private POITypeMaster poiTypeMaster;
    private String rfId;
    private String qrCode;
    private int userGroupId;

}
