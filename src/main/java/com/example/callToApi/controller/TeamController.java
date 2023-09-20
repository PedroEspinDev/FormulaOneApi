package com.example.callToApi.controller;

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
}


