package com.example.callToApi.controller;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.exceptions.DriverNotFoundException;
import com.example.callToApi.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DriverController {
    private final DriverService driverService;

    /*
      1. Crear un endpoint que devuelva los pilotos de la base de datos buscados por nombre,
        en caso de no encontrarlos por estar vacía, buscará en la API externa
        y los guardará en nuestra la base de datos.
    */
    @GetMapping("/driver/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Driver>> getDriversInfo(
            @PathVariable String name) {
        return ResponseEntity.ok(driverService.getDriver(name));
    }

    @GetMapping("/allDrivers")
    public ResponseEntity<List<Driver>> getAllDriversInfo() {
     Optional <List<Driver>> optionalDrivers = Optional.of(driverService.getAllDrivers());
        return new ResponseEntity(optionalDrivers, HttpStatus.OK);
    }

    @GetMapping("/driverById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional> getDriverById(@PathVariable Long id) {
        Driver optionalDriver = driverService.getDriverById(id);

        return ResponseEntity.ok(Optional.of(optionalDriver));
    }

    @DeleteMapping("/deleteDriverById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteDriverById(@PathVariable Long id) {
        driverService.deleteDriverById(id);

        return ResponseEntity.ok("Driver with id: " + id + " was deleted");
    }
    @PutMapping("/updateDriver/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        Driver _driver = driverService.getDriverById(id);

        return new ResponseEntity<>(driverService.saveDriver(_driver), HttpStatus.OK);
    }

}


