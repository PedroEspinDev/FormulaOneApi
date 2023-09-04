package com.example.callToApi.dto;

import com.example.callToApi.entity.Driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DriverDto extends Driver {

    private String name;
    private String nacionality;

}


