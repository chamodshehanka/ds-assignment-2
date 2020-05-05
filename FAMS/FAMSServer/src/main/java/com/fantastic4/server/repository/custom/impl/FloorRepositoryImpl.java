package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.server.repository.custom.FloorRepository;

import java.util.List;

public class FloorRepositoryImpl implements FloorRepository {
    @Override
    public boolean save(FloorDTO floorDTO) throws Exception {
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
        return null;
    }
}
