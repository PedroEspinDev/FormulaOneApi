package com.example.callToApi.externalApi;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.entity.Team;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Response {
    private List<Driver> driverResponse;
    private List<Team> teamResponse;

}
