package com.swm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ese_state_master")
@Data
@NoArgsConstructor
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "iso_short_code")
    private String isoShortCode;

    @Column(name = "vehicle_code")
    private String vehicleCode;

    @Column(name = "capital")
    private String capital;

    @Column(name = "population")
    private String population;

    @Column(name = "area")
    private String area;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "zone_id",nullable = false )
    private Zone zone;


}
