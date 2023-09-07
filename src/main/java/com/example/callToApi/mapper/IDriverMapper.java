package com.example.callToApi.mapper;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDriverMapper {

    public static DriverDto entityToDto(Driver driver) {
        DriverDto driverDto = new DriverDto();
        driverDto.setId(driver.getId());
        driverDto.setName(driver.getName());
        driverDto.setGrands_prix_entered(driver.getGrands_prix_entered());
        driverDto.setPodiums(driver.getPodiums());
        driverDto.setWorld_championships(driver.getWorld_championships());
        return driverDto;
    }

    public static Driver dtoToEntity(DriverDto driverDto) {
        Driver driver = new Driver();

        driver.setId(driverDto.getId());
        driver.setGrands_prix_entered(driverDto.getGrands_prix_entered());
        driver.setPodiums(driverDto.getPodiums());
        driver.setWorld_championships(driverDto.getWorld_championships());
        return driver;
    }
}
