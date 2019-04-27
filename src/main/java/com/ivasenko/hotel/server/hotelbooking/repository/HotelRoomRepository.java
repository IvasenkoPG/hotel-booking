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
//    /**
//     * Method returns all reserved hotel rooms.
//     *
//     * @param status hotel room typeRoom.
//     * @return List<HotelRoomDto>
//     */
//    @Query("SELECT" +
//            " NEW com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomDto" +
//            "(hr.id, hr.numberRoom, hr.typeRoom, hr.facilitie, hr.service, hr.price, hr.additionalPrice," +
//            " hr.countAdditionalPrice, hr.countPrice, hr.status, hr.profiles)" +
//            " FROM HotelRooms hr" +
//            " LEFT JOIN  hr.profiles p" +
////            " LEFT JOIN  hr.reservationDates rd" +
//            " WHERE hr.status = :status")
//    List<HotelRoomDto> findReservedByTypeRoom(@Param("status") final Boolean status);
//
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
//
//    /**
//     * Method returns all hotel rooms by type room.
//     *https://github.com/IvasenkoPG/hotel-booking/tree/master
//     * @param typeRoom hotel room typeRoom.
//     * @return List<HotelRoomDto>
//     */
//    List<HotelRooms> findByTypeRoom(String typeRoom);
//
//    /**
//     * Method returns all hotel rooms.
//     *
//     * @return List<HotelRoom>
//     */
//    List<HotelRooms> findAll();
//
//    /**
//     * Method search for hotel room by passport.
//     *
//     * @param passport passport
//     * @return HotelRooms
//     */
//    HotelRooms findHotelRoomsByProfiles_Passport(String passport);
//
//
//
//    @Query(value = "SELECT COUNT(*) FROM reservation_date" +
//            " WHERE start_date >=:startDateClient AND finish_date<=:finishDateClient", nativeQuery = true)
//    int existsFreeDate(@Param("startDateClient") final String startDateClient, @Param("finishDateClient") final String finishDateClient);

    HotelRooms save(HotelRooms hotelRooms);
}


