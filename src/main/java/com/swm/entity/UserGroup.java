package com.swm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ese_user_group")
@NoArgsConstructor
@Data
public class UserGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
