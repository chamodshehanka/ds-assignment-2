package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.server.repository.custom.FloorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class FloorRepositoryImpl implements FloorRepository {

    private final HttpClient client;

    public FloorRepositoryImpl() {
        client = HttpClient.newHttpClient();
    }

    @Override
    public boolean save(FloorDTO floorDTO) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/createFloor"))
                .POST(HttpRequest.BodyPublishers.ofString(floorDTO.toString()))
                .build();

        HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.println(response.statusCode());
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(FloorDTO floorDTO) throws Exception {
        return false;
    }

    @Override
    public FloorDTO findById(String s) throws Exception {
        return null;
    }

    @Override
    public List<FloorDTO> findAll() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getAllFloors"))
                .build();

        List<FloorDTO> floorDTOList = new ArrayList<>();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        ObjectMapper mapper = new ObjectMapper();
        jsonArray.forEach(object -> {
            try {
                floorDTOList.add(mapper.readValue(object.toString(), FloorDTO.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return floorDTOList;
    }
}
