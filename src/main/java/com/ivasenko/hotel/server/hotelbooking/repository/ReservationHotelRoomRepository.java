package com.ivasenko.hotel.server.hotelbooking.repository;

import com.ivasenko.hotel.server.hotelbooking.entity.ReservationHotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Represents ReservationHotelRoomService repository interface.
 */

@Repository
public interface ReservationHotelRoomRepository extends JpaRepository<ReservationHotelRoom, Long> {
}
