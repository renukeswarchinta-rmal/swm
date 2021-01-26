package com.swm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ese_property_usage_type_master")
@Data
@NoArgsConstructor
public class PropertyUsageTypeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_usage_type_name")
    private String propertyUsageTypeName;

    @Column(name = "property_usage_type_desc")
    private String propertyUsageTypeDescription;

}
