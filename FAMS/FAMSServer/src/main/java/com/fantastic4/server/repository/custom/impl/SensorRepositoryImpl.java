package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.dto.SensorDataDTO;
import com.fantastic4.server.repository.custom.SensorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class SensorRepositoryImpl implements SensorRepository {

    private final HttpClient client;

    public SensorRepositoryImpl() {
        client = HttpClient.newHttpClient();
    }

    @Override
    public boolean save(SensorDTO sensorDTO) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/createSensor"))
                .POST(HttpRequest.BodyPublishers.ofString(sensorDTO.toString()))
                .build();

        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.statusCode());
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/deleteSensor?sensorID=" + id))
                .DELETE().build();
        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response + ":" + response.statusCode());
        return false;
    }

    @Override
    public boolean update(SensorDTO sensorDTO) throws Exception {
        return false;
    }

    @Override
    public SensorDTO findById(String s) throws Exception {
        return null;
    }

    @Override
    public List<SensorDTO> findAll() throws IOException, InterruptedException {
        System.out.println("Inside getAllSensors SensorRepository");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getAllSensors"))
                .build();

        List<SensorDTO> sensorDTOList = new ArrayList<>();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        ObjectMapper mapper = new ObjectMapper();
        jsonArray.forEach(object -> {
            try {
                sensorDTOList.add(mapper.readValue(object.toString(), SensorDTO.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return sensorDTOList;
    }
}
