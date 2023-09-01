package com.example.callToApi.mapper;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component

//Generamos la clase Mapper para poder así gestionar la conversión de datos por las diferentes clases.
public class DriverMapper {

    public Driver map(Driver driver, DriverDto driverDto) {
        if (null == driver || null == driverDto) {
            return driver;
        }
        driver.setId(driverDto.getId());
        driver.setName(driverDto.getName());
        driver.setAge(driverDto.getAge());
        driver.setNacionality(driverDto.getNacionality());
        return driver;
    }
}
