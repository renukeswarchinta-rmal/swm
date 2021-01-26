package com.swm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ese_poi_type_master")
@NoArgsConstructor
@Data
public class POITypeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "poi_type_name")
    private String poiTypeName;

    @Column(name = "poi_type_desc")
    private String poiTypeDesc;
}
