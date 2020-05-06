package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.server.repository.custom.RoomRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    private final HttpClient client;

    public RoomRepositoryImpl() {
        client = HttpClient.newHttpClient();
    }

    @Override
    public boolean save(RoomDTO roomDTO) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/createRoom"))
                .POST(HttpRequest.BodyPublishers.ofString(roomDTO.toString()))
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
    public boolean update(RoomDTO roomDTO) throws Exception {
        return false;
    }

    @Override
    public RoomDTO findById(String s) throws Exception {
        return null;
    }

    @Override
    public List<RoomDTO> findAll() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getAllRooms"))
                .build();

        List<RoomDTO> roomDTOList = new ArrayList<>();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        ObjectMapper mapper = new ObjectMapper();
        jsonArray.forEach(object -> {
            try {
                roomDTOList.add(mapper.readValue(object.toString(), RoomDTO.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return roomDTOList;
    }
}

