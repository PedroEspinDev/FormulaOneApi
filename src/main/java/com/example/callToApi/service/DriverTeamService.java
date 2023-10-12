package com.example.callToApi.service;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DriverTeamService {

    private final TeamService teamService;
    private final DriverService driverService;

    public void associateDriveWithTeam(Long idDriver, Long idTeam) {
        Team team = teamService.getTeamById(idTeam);
        Driver drive = driverService.getDriverById(idDriver);
        team.getDriver().add(drive);
        drive.setId_team(team.getId());
        teamService.saveTeam(team);
        driverService.saveDrive(drive);
    }

}
