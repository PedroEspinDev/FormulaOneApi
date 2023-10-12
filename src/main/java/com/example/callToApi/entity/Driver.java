package com.example.callToApi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "driver")
public class Driver {
    @Id
    private Long id;
    private String name;
    private String abbr;
    private String nationality;
    private String birthdate;
    private String birthplace;
    private Integer grands_prix_entered;
    private Integer world_championships;
    private Integer podiums;
    private Long id_team;


}

