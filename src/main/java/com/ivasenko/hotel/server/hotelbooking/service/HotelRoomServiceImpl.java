package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomDto;
import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileCostDto;
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

//    /**
//     * Method returns all reserved hotel rooms.
//     *
//     * @param status hotel room typeRoom.
//     * @return List<HotelRoomDto>
//     */
//    @Override
//    public List<HotelRoomDto> findReservedByTypeRoom(Boolean status) {
//        if (LOG.isDebugEnabled()) {
//            LOG.debug("Request to get all reserved hotel room typeRoom: ", status);
//        }
//        return hotelRoomRepository.findReservedByTypeRoom(status);
//    }
//
//    /**
//     * Method returns all free hotel rooms.
//     *
//     * @param status hotel room typeRoom.
//     * @return List<HotelRoomDto>
//     */
    @Override
    public List<HotelRooms> findAllHotelRoomsFreeByDates(String startDateClient, String finishDateClient){
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all free hotel room by Dates: ", startDateClient, finishDateClient);
        }
        return hotelRoomRepository.findAllHotelRoomsFreeByDates(startDateClient, finishDateClient);
    }

    /**
     * Method returns all hotel rooms by type room.
     *
     * @param typeRoom hotel room typeRoom.
     * @return List<HotelRoom>
     */
    @Override
    public List<HotelRooms> findByTypeRoom(String typeRoom) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all hotel room typeRoom: ", typeRoom);
        }

        return hotelRoomRepository.findByTypeRoom(typeRoom);
    }

    /**
     * Method returns all hotel rooms.
     *
     * @return List<HotelRoomDto>
     */
    @Override
    public List<HotelRooms> findAll() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all hotel room");
        }
        return hotelRoomRepository.findAll();
    }

    /**
     * Method returns hotel room profile.
     *
     * @return HotelRooms
     */
    @Override
    public HotelRoomDto findHotelRoomByPassport(String passport) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to return hotel room by passport: ", passport);
        }
        return hotelRoomRepository.findHotelRoomsByPassport(passport);
    }


    /**
     * Method returns hotel room total price.
     *
     * @param passport passport.
     * @return HotelRoomProfileCostDto
     */
    @Override
    public HotelRoomProfileCostDto findHotelRoomCost(String passport) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to return cost hotel room by passport: ", passport);
        }
        HotelRoomDto hotelRoomsByProfilePassport = hotelRoomRepository.findHotelRoomsByPassport(passport);
        HotelRoomProfileCostDto hotelRoomProfileCostDto = new HotelRoomProfileCostDto();
        hotelRoomProfileCostDto.setId(hotelRoomsByProfilePassport.getId());
        hotelRoomProfileCostDto.setAdditionalPriceForOptionCount(hotelRoomsByProfilePassport.getAdditionalPriceForOptionCount());
        hotelRoomProfileCostDto.setPriceRoomCount(hotelRoomsByProfilePassport.getPriceRoomCount());
        hotelRoomProfileCostDto.setTotalRoom(hotelRoomsByProfilePassport.getAdditionalPriceForOptionCount() + hotelRoomsByProfilePassport.getPriceRoomCount());
        return hotelRoomProfileCostDto;
    }

    @Override
    public HotelRooms updateHotelRooms(HotelRooms hotelRooms) {
        return hotelRoomRepository.save(hotelRooms);
    }

}
