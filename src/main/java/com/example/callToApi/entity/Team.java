package com.example.callToApi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Team {
    @Id
    private Long id;
    private String name;
    private String base;
    private String president;
    private String director;
    private String technical_manager;
    private Integer world_championships;
    private Integer first_team_entry;
    private String engine;
    private String chassis;
}

