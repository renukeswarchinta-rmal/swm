package com.swm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "poi_master")
public class POIMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ward_id")
    private WardMaster wardMaster;
    @Column(name = "holding_no")
    private String holding_no;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyTypeMaster property_type;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "usage_type_id")
    private PropertyUsageTypeMaster propertyUsageTypeMaster;
    @Column(name = "plot_no")
    private String plot_no;
    @Column(name = "owner_name")
    private String owner_name;
    @Column(name = "guardian_name")
    private String guardian_name;
    @Column(name = "mobile_no")
    private String mobile_number;
    @Column(name = "property_address")
    private  String property_address;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pin_id")
    private PinCode pinCode;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "poi_type_id")
    private POITypeMaster poiTypeMaster;
    @Column(name = "rfid_code")
    private String rfId;
    @Column(name = "qr_code")
    private String qrCode;
    @Column(name= "user_group_id")
    private int userGroupId;

}
