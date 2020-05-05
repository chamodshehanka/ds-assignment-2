package com.fantastic4.server.business.custom.impl;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.server.business.custom.RoomBO;
import com.fantastic4.server.repository.RepositoryFactory;
import com.fantastic4.server.repository.custom.RoomRepository;

import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomRepository roomRepository;

    public RoomBOImpl() {
        roomRepository = (RoomRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.ROOM);
    }

    @Override
    public boolean addRoom(RoomDTO roomDTO) throws Exception {
        return roomRepository.save(roomDTO);
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        return roomRepository.update(roomDTO);
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomRepository.delete(id);
    }

    @Override
    public RoomDTO findRoomByID(String id) throws Exception {
        return roomRepository.findById(id);
    }

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        return roomRepository.findAll();
    }
}
