package com.example.callToApi.controller;

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
    @Autowired
    private IDriverRepository driverRepository;
    /*
      1. Crear un endpoint que devuelva todos los drivers de la base de datos.
        en caso de no encontrarlos por estar vacía, buscará en la API externa
        y los guardará en la base de datos.


    @GetMapping("/drivers")
    public ResponseEntity<String> getDriverJson(@PathVariable Integer id) {
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isPresent()) {
            try {
                Driver diver = driverOptional.get();
                String driverJson = driverMapper.DriverToJSON(driverOptional.get());
                return ResponseEntity.ok(driverJson);
            } catch (JsonProcessingException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to convert to JSON");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}


