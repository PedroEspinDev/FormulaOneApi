package com.example.callToApi.controller;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.repository.IDriverRepository;
import com.example.callToApi.service.DriverService;
import com.example.callToApi.service.RestInvoker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DriverController {
    private final DriverService driverService;
    private final IDriverRepository driverRepository;

    /*
      1. Crear un endpoint que devuelva los pilotos de la base de datos buscados por nombre,
        en caso de no encontrarlos por estar vacía, buscará en la API externa
        y los guardará en nuestra la base de datos.
    */
    @GetMapping("/driver/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Driver>> getDriversInfo(@PathVariable String name) {

        return ResponseEntity.ok(driverService.getDrivers(name));
    }
    @GetMapping("/allDrivers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Driver>> getAllDriversInfo() {

        return ResponseEntity.ok(driverService.getAllDrivers());
    }
}


