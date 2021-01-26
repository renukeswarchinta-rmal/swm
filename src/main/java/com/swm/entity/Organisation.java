package com.swm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "ese_organisation")
@Entity
@NoArgsConstructor
@Data
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_name")
    private String organizationName;
    @JsonIgnore
    @OneToMany(mappedBy = "organisation",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Users> users;

}
