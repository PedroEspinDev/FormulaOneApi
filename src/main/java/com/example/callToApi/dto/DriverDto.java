package com.example.callToApi.dto;

import com.example.callToApi.entity.Driver;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto extends Driver {

    private Integer grands_prix_entered;
    private Integer world_championships;
    private Integer podiums;

}


