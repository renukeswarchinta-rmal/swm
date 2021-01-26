package com.swm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ese_property_type_master")
@Data
@NoArgsConstructor
public class PropertyTypeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_type_name")
    private String propertyTypeName;

    @Column(name = "property_type_desc")
    private String propertyTypeDescription;

}
