package com.example.callToApi.service;

import com.example.callToApi.dto.TeamDto;
import com.example.callToApi.entity.Team;
import com.example.callToApi.exceptions.EntityNotFoundException;
import com.example.callToApi.externalApi.formula.invoker.TeamRestInvoker;
import com.example.callToApi.factory.TeamFactory;
import com.example.callToApi.repository.ITeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {
    private final ITeamRepository teamRepository;
    private final TeamRestInvoker teamRestInvoker;

    private final TeamFactory teamFactory;

    public List<Team> getTeam(String name) {
        List<Team> matchingTeams = teamRepository.findByNameContainingIgnoreCase(name);

        if (matchingTeams.isEmpty()) {
            matchingTeams = teamRestInvoker.getTeams(name);
            if (matchingTeams.isEmpty()) {
                throw new EntityNotFoundException("Not found team with name: " + name);
            }
            return teamRepository.saveAll(matchingTeams);
        } else {
            return matchingTeams;
        }
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found Team with id = " + id));
    }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    public void updateTeam(Long id, TeamDto teamDto) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found Team with ID: " + id));
        teamRepository.save(teamFactory.create(team, teamDto));
    }
}