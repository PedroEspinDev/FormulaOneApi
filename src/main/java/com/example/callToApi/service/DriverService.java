package com.example.callToApi.service;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import com.example.callToApi.exceptions.DriverNotFoundException;
import com.example.callToApi.mapper.IDriverMapper;
import com.example.callToApi.repository.IDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DriverService {
    private final IDriverRepository driverRepository;
    private final RestInvoker restInvoker;

    private final IDriverMapper driverMapper;

    public List<Driver> getDriver(String name) {
        List<Driver> matchingDrivers = driverRepository.findByNameContainingIgnoreCase(name);

        if (matchingDrivers.isEmpty()) {
            matchingDrivers = restInvoker.getDriver(name);
            if (matchingDrivers.isEmpty()) {
                throw new DriverNotFoundException("Not found driver with name: " + name);
            }
            return driverRepository.saveAll(matchingDrivers);
        } else {
            return matchingDrivers;
        }
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        Optional<Driver> optionalDriver = driverRepository.findById(id);

        return optionalDriver.orElseThrow(() -> new DriverNotFoundException("Not found Driver with id = " + id));
    }

    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Long id, DriverDto driverDto) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Not found Driver with ID: " + id));

        driver.setGrands_prix_entered(driverDto.getGrands_prix_entered());
        driver.setPodiums(driverDto.getPodiums());
        driver.setWorld_championships(driverDto.getWorld_championships());

        return driverRepository.save(driver);

    }

}



