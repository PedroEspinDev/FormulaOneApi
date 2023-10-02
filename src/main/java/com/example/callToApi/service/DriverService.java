package com.example.callToApi.service;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import com.example.callToApi.exceptions.EntityNotFoundException;
import com.example.callToApi.externalApi.formula.invoker.DriverRestInvoker;
import com.example.callToApi.factory.DriverFactory;
import com.example.callToApi.repository.IDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DriverService {
    private final IDriverRepository driverRepository;
    private final DriverRestInvoker driverRestInvoker;
    private final DriverFactory driverFactory;

    public List<Driver> getDriver(String name) {
        List<Driver> matchingDrivers = driverRepository.findByNameContainingIgnoreCase(name);

        if (matchingDrivers.isEmpty()) {
            matchingDrivers = driverRestInvoker.getDrivers(name);
            if (matchingDrivers.isEmpty()) {
                throw new EntityNotFoundException("Not found driver with name: " + name);
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

        return optionalDriver.orElseThrow(() -> new EntityNotFoundException("Not found Driver with id = " + id));
    }

    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }

    public void updateDriver(Long id, DriverDto driverDto) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found Driver with ID: " + id));

        driverRepository.save(driverFactory.create(driver, driverDto));

    }

}



