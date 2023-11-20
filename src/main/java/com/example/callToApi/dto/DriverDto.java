package com.example.callToApi.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter


public class DriverDto extends Driver {

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {


    private Integer grands_prix_entered;
    private Integer world_championships;
    private Integer podiums;

}


