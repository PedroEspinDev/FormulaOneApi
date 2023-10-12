package com.example.callToApi.controller;

import com.example.callToApi.service.DriverTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class DriverTeamController {

    private final DriverTeamService driverTeamService;

    @PutMapping("/associate/driver/{idDriver}/team/{idTeam}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDriverById(@PathVariable Long idDriver, @PathVariable Long idTeam) {
        driverTeamService.associateDriveWithTeam(idDriver, idTeam);

    }
}
