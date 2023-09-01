package com.example.callToApi.service;

import com.example.callToApi.entity.Driver;
import com.example.callToApi.repository.IDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DriverService {

    //Declaramos el repositorio y el restTemplate
    private final IDriverRepository driverRepository;
    @Autowired
    private final RestTemplate restTemplate;

    //Declaramos la URL de la API externa con el marcador de posición para el nombre del piloto
    private static final String F1_API_URL = "https://v1.formula-1.api-sports.io/{driver}";

    //Declaramos el método que nos devolverá la lista de pilotos

    public List<Driver> getAndSaveDrivers() {
        //Declaramos los headers para configurar los encabezados HTTP,
        //son utilizados por la API externa para indentificar el host y atentificación.

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key", "8010659d3db4840e870bc96299d1341d");
        headers.add("x-rapidapi-host", "v1.formula-1.api-sports.io");

        //Objeto que nos permite construir la URL con los parámetros que necesitamos
        HttpEntity<?> entity = new HttpEntity<>(headers);
        /*
        1.Generamos una variable 'response' que contendrá la lista de pilotos.
        2.Usamos el restTemplate.exchange para una solicitud HTTP GET a la URL 'F1_API_URL'.
        3.Se utiliza ParameterizedTypeReference para indicar el tipo de respuesta esperado,
          que es una lista de objetos Driver.
        4.Como parte final, se utiliza el método getBody() para obtener la lista de pilotos
          y guardarla en BBDD utilizando el método 'saveAll'.
         */
        ResponseEntity<List<Driver>> response = restTemplate.exchange(
                F1_API_URL,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Driver>>() {
                }
        );

        List<Driver> drivers = response.getBody();
        driverRepository.saveAll(drivers);

        return drivers;
    }
}


