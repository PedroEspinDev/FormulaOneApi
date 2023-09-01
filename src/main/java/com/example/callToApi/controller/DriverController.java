package com.example.callToApi.controller;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import com.example.callToApi.mapper.DriverMapper;
import com.example.callToApi.repository.IDriverRepository;
import com.example.callToApi.service.DriverService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;
    @Autowired
    private DriverMapper driverMapper;
    /*
      1. Crear un endpoint que devuelva todos los drivers de la base de datos.
        en caso de no encontrarlos por estar vacía, buscará en la API externa
        y los guardará en la base de datos.
    */
    @PostMapping("/info")
    public ResponseEntity <?> getDrivers() {
        List<Driver> drivers = driverService.getAndSaveDrivers();

        return ResponseEntity.ok("Drivers saved");
    }
}


