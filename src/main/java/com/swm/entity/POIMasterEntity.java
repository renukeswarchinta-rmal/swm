package com.swm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "poi_master")
public class POIMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "poi_id")
    private Long poi_id;
    @Column(name = "ward_id")
    private String ward_id;
    @Column(name = "holding_no")
    private String holding_no;
    @Column(name = "usage_type")
    private String usage_type;
    @Column(name = "property_type")
    private String property_type;
    @Column(name = "plot_no")
    private String plot_no;
    @Column(name = "owner_name")
    private String owner_name;
    @Column(name = "guardian_name")
    private String guardian_name;
    @Column(name = "mobile_number")
    private String mobile_number;
    @Column(name = "property_address")
    private  String property_address;
    @Column(name = "city")
    private String city;
    @Column(name = "pin")
    private int pin;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;
}
