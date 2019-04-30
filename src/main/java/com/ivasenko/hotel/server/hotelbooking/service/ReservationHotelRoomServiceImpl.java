package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.entity.ReservationHotelRoom;
import com.ivasenko.hotel.server.hotelbooking.repository.ReservationHotelRoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class represents ReservationHotelRoomService implementation.
 */

@Service
public class ReservationHotelRoomServiceImpl implements ReservationHotelRoomService{

    private static final Logger LOG = LoggerFactory.getLogger(HotelRoomServiceImpl.class);

    private final ReservationHotelRoomRepository reservationHotelRoomRepository;

    @Autowired
    public ReservationHotelRoomServiceImpl(ReservationHotelRoomRepository reservationHotelRoomRepository) {
        this.reservationHotelRoomRepository = reservationHotelRoomRepository;
    }

    /**
     * Method save new reservationHotelRoom to database.
     *
     * @param reservationHotelRoom new reservationHotelRoom
     * @return ReservationHotelRoom
     */

    @Override
    public ReservationHotelRoom reservationHotelRoom(ReservationHotelRoom reservationHotelRoom) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to add ReservationHotelRoom : {}", reservationHotelRoom);
        }

//        reservationHotelRoom.setProfiles();
//        reservationHotelRoom.setHotelRooms();
        return reservationHotelRoomRepository.saveAndFlush(reservationHotelRoom);
    }
}
