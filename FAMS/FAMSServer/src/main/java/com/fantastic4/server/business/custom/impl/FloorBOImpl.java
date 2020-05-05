package com.fantastic4.server.business.custom.impl;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.server.business.custom.FloorBO;
import com.fantastic4.server.repository.RepositoryFactory;
import com.fantastic4.server.repository.custom.FloorRepository;

import java.util.List;

public class FloorBOImpl implements FloorBO {

    private final FloorRepository floorRepository;

    public FloorBOImpl() {
        floorRepository = (FloorRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.FLOOR);
    }

    @Override
    public boolean addFloor(FloorDTO floorDTO) throws Exception {
        return floorRepository.save(floorDTO);
    }

    @Override
    public boolean updateFloor(FloorDTO floorDTO) throws Exception {
        return floorRepository.update(floorDTO);
    }

    @Override
    public boolean deleteFloor(String id) throws Exception {
        return floorRepository.delete(id);
    }

    @Override
    public FloorDTO findFloorByID(String id) throws Exception {
        return floorRepository.findById(id);
    }

    @Override
    public List<FloorDTO> getAllFloors() throws Exception {
        return floorRepository.findAll();
    }
}
