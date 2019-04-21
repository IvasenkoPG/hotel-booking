package com.ivasenko.hotel.server.hotelbooking.controller;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;
import com.ivasenko.hotel.server.hotelbooking.enums.Message;
import com.ivasenko.hotel.server.hotelbooking.exceptions.ProfileNotFoundException;
import com.ivasenko.hotel.server.hotelbooking.service.HotelRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class represents user com.ivasenko.hotel.server.hotelbooking.controller.
 */

@RestController
@RequestMapping(value = "/api")
public class HotelRoomController {

    private static final Logger LOG = LoggerFactory.getLogger(HotelRoomController.class);

    private final HotelRoomService hotelRoomService;

    @Autowired
    public HotelRoomController(HotelRoomService hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }



    /**
     * Method returns all hotel rooms.
     *
     * @return ResponseEntity
     */
    @GetMapping("/hotelAllRooms")
    public ResponseEntity<List<HotelRooms>> getAllHotelRooms(){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get all Hotel Rooms");
        }
        List<HotelRooms> hotelRooms = hotelRoomService.findAll();
        if(hotelRooms == null || hotelRooms.isEmpty()){
            LOG.info(Message.HOTEL_ROOMS_NOT_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.HOTEL_ROOMS_NOT_FOUND.getMsgBody());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelRooms);
    }

    /**
     * Method returns reserved hotel rooms by type room.
     *
     * @return ResponseEntity
     */
    @GetMapping("/hotelRooms/reserved")
    public ResponseEntity<List<HotelRoomProfileDto>> getAllHotelRoomsReservedByTypeRoom(@RequestParam(name = "typeRoom")String typeRoom){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get all reserved Hotel Rooms by Type Room: {}", typeRoom);
        }
        List<HotelRoomProfileDto> hotelRoomsDto = hotelRoomService.findReservedByTypeRoom(typeRoom);
        if(hotelRoomsDto == null || hotelRoomsDto.isEmpty()){
            LOG.info(Message.HOTEL_ROOMS_NOT_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.HOTEL_ROOMS_NOT_FOUND.getMsgBody());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelRoomsDto);
    }

    /**
     * Method returns hotel rooms by type room.
     *
     * @return ResponseEntity
     */
    @GetMapping("/hotelRooms")
    public ResponseEntity<List<HotelRooms>> getAllHotelRoomsByTypeRoom(@RequestParam(name = "typeRoom")String typeRoom){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get all Hotel Rooms by Type Room: {}", typeRoom);
        }
        List<HotelRooms> hotelRooms = hotelRoomService.findByTypeRoom(typeRoom);
        if(hotelRooms == null || hotelRooms.isEmpty()){
            LOG.info(Message.HOTEL_ROOMS_RESERVED_NOT_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.HOTEL_ROOMS_RESERVED_NOT_FOUND.getMsgBody());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelRooms);
    }
}
