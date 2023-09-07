package com.example.callToApi.dto;

import com.example.callToApi.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto extends Driver {
    private Long id;
    private Integer grands_prix_entered;
    private Integer world_championships;
    private Integer podiums;

}


