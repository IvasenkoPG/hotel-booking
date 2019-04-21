package com.ivasenko.hotel.server.hotelbooking.repository;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileCostDto;
import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Represents Hotel Room repository interface.
 */

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRooms, Long> {
    /**
     * Method returns all reserved hotel rooms by type room.
     *
     * @param typeRoom hotel room typeRoom.
     * @return List<HotelRoomProfileDto>
     */
    @Query("SELECT" +
            " NEW com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileDto" +
            "(hr.id, hr.numberRoom, hr.typeRoom, hr.facilitie, hr.service, hr.price, hr.additionalPrice," +
            " hr.countAdditionalPrice, hr.countPrice, hr.status, hr.profile)" +
            " FROM HotelRooms hr" +
            " LEFT JOIN  hr.profile p" +
            " LEFT JOIN  hr.reservationDates rd" +
            " WHERE hr.typeRoom = :typeRoom")
    List<HotelRoomProfileDto> findReservedByTypeRoom(@Param("typeRoom") final String typeRoom);
//    List<HotelRoomProfileDto> findHotelRoomsByProfileOrderByReservationDates(String typeRoom);

    /**
     * Method returns all hotel rooms by type room.
     *
     * @param typeRoom hotel room typeRoom.
     * @return List<HotelRoomProfileDto>
     */
    List<HotelRooms> findByTypeRoom(String typeRoom);

    /**
     * Method returns all hotel rooms.
     *
     * @return List<HotelRoom>
     */
    List<HotelRooms> findAll();

    /**
     * Method search for hotel room by passport.
     *
     * @param passport passport
     * @return HotelRooms
     */
    HotelRooms findHotelRoomsByProfile_Passport(String passport);

}


