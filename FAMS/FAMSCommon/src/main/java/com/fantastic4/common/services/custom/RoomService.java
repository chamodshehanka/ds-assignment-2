package com.fantastic4.common.services.custom;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.common.services.SuperService;

import java.util.List;

public interface RoomService extends SuperService {

    boolean addRoom(RoomDTO roomDTO) throws Exception;

    boolean updateRoom(RoomDTO roomDTO) throws Exception;

    boolean deleteRoom(String id) throws Exception;

    RoomDTO findRoomByID(String id) throws Exception;

    List<RoomDTO> getAllRooms() throws Exception;

}
