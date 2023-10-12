package com.example.callToApi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "team")
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private List<Driver> driver;
}
