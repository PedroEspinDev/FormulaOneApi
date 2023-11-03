package com.example.callToApi.factory;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverFactory {

    public Driver create (Driver driver, DriverDto driverDto) {
        if (driver == null || driverDto == null) {
            return driver;
        }

        driver.setGrands_prix_entered(driverDto.getGrands_prix_entered());
        driver.setPodiums(driverDto.getPodiums());
        driver.setWorld_championships(driverDto.getWorld_championships());

        return driver;
    }

    public Driver create (DriverDto driverDto) {
        if (driverDto == null) {
            return null;
        }
        return Driver.builder()
                .grands_prix_entered(driverDto.getGrands_prix_entered())
                .podiums(driverDto.getPodiums())
                .world_championships(driverDto.getWorld_championships())
                .build();
    }

    public DriverDto create (Driver driver) {
        if (driver == null) {
            return null;
        }

        return DriverDto.builder()
                .grands_prix_entered(driver.getGrands_prix_entered())
                .podiums(driver.getPodiums())
                .world_championships(driver.getWorld_championships())
                .build();
    }

}
