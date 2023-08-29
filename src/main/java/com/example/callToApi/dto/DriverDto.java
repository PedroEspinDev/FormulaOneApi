package com.example.callToApi.dto;

import com.example.callToApi.entity.Driver;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Generamos DTO para poder trabajar con los datos de la API
public class DriverDto extends Driver {

    private Integer id;
    private String name;
    private Integer age;
    private String nacionality;

}


