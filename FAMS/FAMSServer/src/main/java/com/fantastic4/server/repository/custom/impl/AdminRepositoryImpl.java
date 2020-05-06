package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.server.repository.custom.AdminRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private final HttpClient client;

    public AdminRepositoryImpl() {
        client =  HttpClient.newHttpClient();
    }


    @Override
    public boolean save(AdminDTO adminDTO) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/createAdmin"))
                .POST(HttpRequest.BodyPublishers.ofString(adminDTO.toString()))
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
    public boolean update(AdminDTO adminDTO) throws Exception {
        return false;
    }

    @Override
    public AdminDTO findById(String s) throws Exception {
        return null;
    }

    @Override
    public List<AdminDTO> findAll() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getAllAdmins"))
                .build();

        List<AdminDTO> adminDTOList = new ArrayList<>();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONArray(response.body());
        ObjectMapper mapper = new ObjectMapper();
        jsonArray.forEach(object -> {
            try {
                adminDTOList.add(mapper.readValue(object.toString(), AdminDTO.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return adminDTOList;
    }

    @Override
    public AdminDTO login(AdminDTO adminDTO) throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/login?email="+adminDTO.getEmail()+"&pass="+adminDTO.getPassword()))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        ObjectMapper mapper = new ObjectMapper();
        AdminDTO admin = mapper.readValue(jsonObject.toString(),AdminDTO.class);

        return admin;
    }
}
