package com.example.callToApi.controller;

import com.example.callToApi.dto.TeamDto;
import com.example.callToApi.entity.Team;
import com.example.callToApi.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/team/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Team>> getTeamInfo(
            @PathVariable String name) {
        return ResponseEntity.ok(teamService.getTeam(name));
    }

    @GetMapping("/Teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/teamById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @DeleteMapping("/deleteTeam/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteTeamById(@PathVariable Long id) {
        teamService.deleteTeamById(id);
        return ResponseEntity.ok("Team with id: " + id + " was deleted");
    }

    @PutMapping("/updateTeam/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTeamById(@PathVariable Long id, @RequestBody TeamDto teamDto) {
        teamService.updateTeam(id, teamDto);

    }
}


