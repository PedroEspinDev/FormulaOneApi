package com.example.callToApi.service;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.entity.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestInvoker {

    private final RestTemplate restTemplate;
    private static final String F1_API_URL = "https://v1.formula-1.api-sports.io/drivers?search=";

    public List<Driver> getDriver(String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "128e724cec996bb93f87c571eb590f62");
        headers.add("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com");

        HttpEntity<Driver> entity = new HttpEntity<>(headers);

        ResponseEntity<Response> response = restTemplate.exchange(
                F1_API_URL + name,
                HttpMethod.GET,
                entity,
                Response.class
        );

        if (response.getBody() == null) {
            return new ArrayList<>();
        }
        return response.getBody().getResponse();
    }
}