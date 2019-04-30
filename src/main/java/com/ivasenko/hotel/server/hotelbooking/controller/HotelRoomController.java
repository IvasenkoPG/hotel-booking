package com.ivasenko.hotel.server.hotelbooking.controller;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomDto;
import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileCostDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;
import com.ivasenko.hotel.server.hotelbooking.enums.Message;
import com.ivasenko.hotel.server.hotelbooking.exceptions.ProfileNotFoundException;
import com.ivasenko.hotel.server.hotelbooking.repository.HotelRoomRepository;
import com.ivasenko.hotel.server.hotelbooking.service.HotelRoomService;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class represents hotel room controller.
 */

@RestController
@RequestMapping(value = "/api")
public class HotelRoomController {

    private static final Logger LOG = LoggerFactory.getLogger(HotelRoomController.class);

    private final HotelRoomService hotelRoomService;

    private final HotelRoomRepository hotelRoomRepository;

    private final ProfileService profileService;


    @Autowired
    public HotelRoomController(HotelRoomService hotelRoomService, HotelRoomRepository hotelRoomRepository, ProfileService profileService) {
        this.hotelRoomService = hotelRoomService;
        this.hotelRoomRepository = hotelRoomRepository;
        this.profileService = profileService;
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
     * Method returns free hotel rooms.
     *
     *@RequestParam startDateClient
     *@RequestParam finishDateClient
     *
     * @return ResponseEntity
     */
    @GetMapping("/hotelRooms/free")
    public ResponseEntity<List<HotelRooms>> getAllHotelRoomsFreeByDates(@RequestParam(name = "startDateClient") String startDateClient,
                                                                          @RequestParam(name = "finishDateClient") String finishDateClient){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get all free Hotel Rooms by Dates: {}", startDateClient, finishDateClient);
        }
        List<HotelRooms> allHotelRoomsFreeByDates = hotelRoomService.findAllHotelRoomsFreeByDates(startDateClient, finishDateClient);
            if (allHotelRoomsFreeByDates == null || allHotelRoomsFreeByDates.isEmpty()) {
                LOG.info(Message.HOTEL_ROOMS_OCCUPIED_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.HOTEL_ROOMS_OCCUPIED_FOUND.getMsgBody());
            }
        return ResponseEntity.status(HttpStatus.OK).body(allHotelRoomsFreeByDates);
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

    /**
     * Method returns hotel rooms by passport.
     *
     * @return ResponseEntity
     */
    @GetMapping("/hotelRooms/profile")
    public ResponseEntity<HotelRoomDto> getHotelRoomByPassport(@RequestParam(name = "passport")String passport){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get Hotel Rooms Profile by Passport: {}", passport);
        }

        HotelRoomDto hotelRoomsbyPassport = hotelRoomService.findHotelRoomByPassport(passport);
        if(hotelRoomsbyPassport == null){
            LOG.info(Message.HOTEL_ROOMS_BY_PROFILE_NOT_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.HOTEL_ROOMS_BY_PROFILE_NOT_FOUND.getMsgBody());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelRoomsbyPassport);
    }

    /**
     * Method returns cost hotel rooms by passport.
     *
     * @return ResponseEntity
     */
    @GetMapping("/hotelRooms/cost/profile")
    public ResponseEntity<HotelRoomProfileCostDto> getHotelRoomCostByPassport(@RequestParam(name = "passport")String passport){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get Hotel Rooms Profile by Passport: {}", passport);
        }

        HotelRoomProfileCostDto hotelRoomsCost = hotelRoomService.findHotelRoomCost(passport);
        if(hotelRoomsCost == null){
            LOG.info(Message.HOTEL_ROOMS_BY_PROFILE_NOT_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.HOTEL_ROOMS_BY_PROFILE_NOT_FOUND.getMsgBody());
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelRoomsCost);
    }

}
