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
      1. Crear un endpoint que devuelva todos los drivers de la base de datos.
        en caso de no encontrarlos por estar vacía, buscará en la API externa
        y los guardará en la base de datos.
    */
    @GetMapping("/getinfo/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Driver>> getDriversInfo(@PathVariable String name) {

        return ResponseEntity.ok(driverService.getDrivers(name));
    }
}


