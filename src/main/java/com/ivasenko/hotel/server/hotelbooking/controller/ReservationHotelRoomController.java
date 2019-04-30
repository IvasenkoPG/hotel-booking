package com.ivasenko.hotel.server.hotelbooking.controller;

import com.ivasenko.hotel.server.hotelbooking.entity.ReservationHotelRoom;
import com.ivasenko.hotel.server.hotelbooking.service.ReservationHotelRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class represents reservation Hotel Room controller.
 */

@RestController
@RequestMapping(value = "/api")
public class ReservationHotelRoomController {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileController.class);

    private final ReservationHotelRoomService reservationHotelRoomService;

    @Autowired

    public ReservationHotelRoomController(ReservationHotelRoomService reservationHotelRoomService) {
        this.reservationHotelRoomService = reservationHotelRoomService;
    }

    /**
     * Method performs registration operation for new reservation Hotel Room.
     *
     * @param reservationHotelRoom contains reservationHotelRoom information.
     * @return ResponseEntity
     */
    @PostMapping("/reservation")
    public ResponseEntity<ReservationHotelRoom> addReservationHotelRoom(
            @RequestBody final ReservationHotelRoom reservationHotelRoom) {
        LOG.info("creating new reservation Hotel Room: {}", reservationHotelRoom);

        reservationHotelRoomService.reservationHotelRoom(reservationHotelRoom);

        return ResponseEntity.status(HttpStatus.CREATED).body(reservationHotelRoom);
    }
}
