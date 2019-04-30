package com.ivasenko.hotel.server.hotelbooking.repository;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomDto;
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
     * Method returns all free hotel rooms.
     *
     * @param startDateClient startDateClient.
     * @param finishDateClient finishDateClient.
     *
     * @return List<HotelRooms>
     */
    @Query(value = "SELECT  hr.id, hr.additional_price_for_option, hr.facilitie, hr.number_room, hr.price_room, hr.service, hr.type_room" +
            " FROM hotel_rooms hr " +
            "LEFT JOIN  reservation_hotel_room rhr ON hr.id = rhr.hotel_rooms_id" +
            " WHERE NOT ((start_date BETWEEN :startDateClient AND :finishDateClient) OR (finish_date BETWEEN :startDateClient AND :finishDateClient)) OR start_date IS NULL", nativeQuery = true)
    List<HotelRooms> findAllHotelRoomsFreeByDates(@Param("startDateClient") final String startDateClient, @Param("finishDateClient") final String finishDateClient);

    /**
     * Method returns all hotel rooms by type room.
     *
     * @param typeRoom hotel room typeRoom.
     *
     * @return List<HotelRoom>
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
    @Query("SELECT NEW com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomDto(hr.id, hr.numberRoom, hr.typeRoom," +
            " hr.facilitie, hr.service, rhr.priceRoomCount, rhr.additionalPriceForOptionCount)" +
            "FROM HotelRooms hr " +
            "LEFT JOIN ReservationHotelRoom rhr ON hr.id = hotel_rooms_id " +
            "LEFT JOIN Profile p ON p.id = profiles_id where p.passport = :passport")
    HotelRoomDto findHotelRoomsByPassport(@Param("passport") final String passport);



    HotelRooms findByNumberRoom(Integer numberRoom);
}


