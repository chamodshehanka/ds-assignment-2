package com.fantastic4.server.business.custom;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.server.business.SuperBO;

import java.util.List;

public interface FloorBO extends SuperBO {

    boolean addFloor(FloorDTO floorDTO) throws Exception;

    boolean updateFloor(FloorDTO floorDTO) throws Exception;

    boolean deleteFloor(String id) throws Exception;

    FloorDTO findFloorByID(String id) throws Exception;

    List<FloorDTO> getAllFloors() throws Exception;

}
