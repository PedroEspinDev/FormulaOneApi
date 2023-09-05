package com.example.callToApi.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
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
}

