package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileCostDto;
import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;

import java.util.List;

/**
 * Interface represents Hotel Room service methods.
 */

public interface HotelRoomService {

    List<HotelRoomProfileDto> findReservedByTypeRoom(Boolean status);

    List<HotelRoomProfileDto> findFreeByTypeRoom(Boolean status);

    List<HotelRooms> findByTypeRoom(String typeRoom);

    List<HotelRooms>findAll();

    HotelRooms findByPassport(String passport);

    HotelRoomProfileCostDto findHotelRoomCost(String passport);
}
