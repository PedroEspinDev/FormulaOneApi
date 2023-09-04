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
}

