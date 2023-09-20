package com.example.callToApi.service;

import com.example.callToApi.entity.Team;
import com.example.callToApi.exceptions.EntityNotFoundException;
import com.example.callToApi.externalApi.TeamRestInvoker;
import com.example.callToApi.repository.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final ITeamRepository teamRepository;
    private TeamRestInvoker teamRestInvoker;

    public List<Team> getTeam(String name) {
        List<Team> matchingTeams = teamRepository.findByNameContainingIgnoreCase(name);

        if (matchingTeams.isEmpty()) {
            matchingTeams = teamRestInvoker.getTeam(name);
            if (matchingTeams.isEmpty()) {
                throw new EntityNotFoundException("Not found team with name: " + name);
            }
            return teamRepository.saveAll(matchingTeams);
        } else {
            return matchingTeams;
        }
    }
}