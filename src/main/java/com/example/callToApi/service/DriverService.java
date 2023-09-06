package com.example.callToApi.service;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.repository.IDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DriverService {
    private final IDriverRepository driverRepository;
    private final RestInvoker restInvoker;

    public List<Driver> getDrivers(String name) {
        List<Driver> matchingDrivers = driverRepository.findByNameContainingIgnoreCase(name);
        if (matchingDrivers.isEmpty()) {
            matchingDrivers = restInvoker.getDriver(name);
            return driverRepository.saveAll(matchingDrivers);
        }
        return matchingDrivers;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

}



