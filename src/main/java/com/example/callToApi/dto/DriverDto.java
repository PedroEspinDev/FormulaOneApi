package com.example.callToApi.dto;

import com.example.callToApi.entity.Driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DriverDto extends Driver {

    private Integer id;
    private String name;
    private Integer age;
    private String nacionality;

}


