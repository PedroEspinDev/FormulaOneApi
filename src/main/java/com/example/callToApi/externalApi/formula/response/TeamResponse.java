package com.example.callToApi.externalApi.formula.response;

import com.example.callToApi.entity.Team;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class TeamResponse {
    private List<Team> response;
}
