package com.ivasenko.hotel.server.hotelbooking.dto;


import com.ivasenko.hotel.server.hotelbooking.entity.ReservationHotelRoom;

import java.util.Set;

/**
 * Class represents Hotel Room Dto.
 */

public class HotelRoomDto {

    private Long id;

    private Integer numberRoom;

    private String typeRoom;

    private String facilitie;

    private String service;

    private Integer priceRoomCount;

    private Integer additionalPriceForOptionCount;




    public HotelRoomDto() {
    }

    public HotelRoomDto(Long id, Integer numberRoom, String typeRoom, String facilitie, String service) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
    }

    public HotelRoomDto(Long id, Integer numberRoom, String typeRoom, String facilitie, String service,
                        Integer priceRoomCount, Integer additionalPriceForOptionCount) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.priceRoomCount = priceRoomCount;
        this.additionalPriceForOptionCount = additionalPriceForOptionCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getFacilitie() {
        return facilitie;
    }

    public void setFacilitie(String facilitie) {
        this.facilitie = facilitie;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getPriceRoomCount() {
        return priceRoomCount;
    }

    public void setPriceRoomCount(Integer priceRoomCount) {
        this.priceRoomCount = priceRoomCount;
    }

    public Integer getAdditionalPriceForOptionCount() {
        return additionalPriceForOptionCount;
    }

    public void setAdditionalPriceForOptionCount(Integer additionalPriceForOptionCount) {
        this.additionalPriceForOptionCount = additionalPriceForOptionCount;
    }
}
