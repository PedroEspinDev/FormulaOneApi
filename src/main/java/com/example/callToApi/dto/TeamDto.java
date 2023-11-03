package com.example.callToApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "team")
public class TeamDto {
    @Id
    private Long id;
    private String base;
    private String president;
    private String director;
    private String technical_manager;
    private Integer world_championships;
    private String engine;
    private String chassis;
}
