package com.example.callToApi.factory;

import com.example.callToApi.dto.TeamDto;
import com.example.callToApi.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamFactory {

    public Team create(Team team, TeamDto teamDto) {
        team.setId(teamDto.getId());
        team.setBase(teamDto.getBase());
        team.setPresident(teamDto.getPresident());
        team.setDirector(teamDto.getDirector());
        team.setTechnical_manager(teamDto.getTechnical_manager());
        team.setWorld_championships(teamDto.getWorld_championships());
        team.setEngine(teamDto.getEngine());
        team.setChassis(teamDto.getChassis());
        return team;
    }
}
