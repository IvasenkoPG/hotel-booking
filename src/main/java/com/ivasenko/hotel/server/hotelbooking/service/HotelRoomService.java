package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomDto;
import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileCostDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;

import java.util.List;

/**
 * Interface represents Hotel Room service methods.
 */

public interface HotelRoomService {


    List<HotelRooms> findAllHotelRoomsFreeByDates(String startDateClient, String finishDateClient);

    List<HotelRooms> findByTypeRoom(String typeRoom);

    List<HotelRooms>findAll();

    HotelRoomDto findHotelRoomByPassport(String passport);

    HotelRoomProfileCostDto findHotelRoomCost(String passport);

}
