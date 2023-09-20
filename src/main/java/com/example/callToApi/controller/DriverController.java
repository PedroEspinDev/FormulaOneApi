package com.example.callToApi.controller;

import com.example.callToApi.dto.DriverDto;
import com.example.callToApi.entity.Driver;
import com.example.callToApi.exceptions.EntityNotFoundException;
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

    @GetMapping("/driver/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Driver>> getDriversInfo(
            @PathVariable String name) {
        return ResponseEntity.ok(driverService.getDriver(name));
    }

    @GetMapping("/allDrivers")
    public ResponseEntity<List<Driver>> getAllDriversInfo() {
        Optional<List<Driver>> optionalDrivers = Optional.of(driverService.getAllDrivers());
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
    @ResponseStatus(HttpStatus.OK)
    public void updateDriverById(@PathVariable Long id, @RequestBody DriverDto driverDto) {
        driverService.updateDriver(id, driverDto);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}


