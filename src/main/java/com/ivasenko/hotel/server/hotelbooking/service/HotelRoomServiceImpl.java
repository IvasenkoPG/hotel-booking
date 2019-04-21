package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;
import com.ivasenko.hotel.server.hotelbooking.repository.HotelRoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class represents HotelRoomService implementation.
 */

@Service
public class HotelRoomServiceImpl implements HotelRoomService{

    private static final Logger LOG = LoggerFactory.getLogger(HotelRoomServiceImpl.class);

    private final HotelRoomRepository hotelRoomRepository;

    @Autowired
    public HotelRoomServiceImpl(HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

    /**
     * Method returns all reserved hotel rooms by type room.
     *
     * @param typeRoom hotel room typeRoom.
     * @return List<HotelRoomProfileDto>
     */
    @Override
    public List<HotelRoomProfileDto> findReservedByTypeRoom(String typeRoom) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all reserved hotel room typeRoom");
        }
        return hotelRoomRepository.findReservedByTypeRoom(typeRoom);
    }

    /**
     * Method returns all hotel rooms by type room.
     *
     * @param typeRoom hotel room typeRoom.
     * @return List<HotelRoomProfileDto>
     */
    @Override
    public List<HotelRooms> findByTypeRoom(String typeRoom) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all hotel room typeRoom");
        }

        return hotelRoomRepository.findByTypeRoom(typeRoom);
    }

    /**
     * Method returns all hotel rooms.
     *
     * @return List<HotelRoomProfileDto>
     */
    @Override
    public List<HotelRooms> findAll() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all hotel room");
        }
        return hotelRoomRepository.findAll();
    }


}