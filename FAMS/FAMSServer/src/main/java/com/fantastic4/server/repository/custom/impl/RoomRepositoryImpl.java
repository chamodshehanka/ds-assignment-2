package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.server.repository.custom.RoomRepository;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    @Override
    public boolean save(RoomDTO roomDTO) throws Exception {
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
        return null;
    }
}

