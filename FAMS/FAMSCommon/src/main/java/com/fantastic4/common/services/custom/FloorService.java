package com.fantastic4.common.services.custom;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.common.services.SuperService;

import java.util.List;

public interface FloorService extends SuperService {

    boolean addFloor(FloorDTO floorDTO) throws Exception;

    boolean updateFloor(FloorDTO floorDTO) throws Exception;

    boolean deleteFloor(String id) throws Exception;

    FloorDTO findFloorByID(String id) throws Exception;

    List<FloorDTO> getAllFloors() throws Exception;

}
