package com.swm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ese_zone_master")
@Data
@NoArgsConstructor
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_name")
    private String zoneName;

    @Column(name = "zone_desc")
    private String zoneDesc;

    @OneToMany(mappedBy = "zone",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<State> states;


}
