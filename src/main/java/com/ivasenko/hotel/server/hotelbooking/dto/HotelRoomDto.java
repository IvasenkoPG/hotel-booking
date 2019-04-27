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

    private Integer priceRoom;

    private Integer additionalPriceForOption;

    public HotelRoomDto() {
    }

    public HotelRoomDto(Long id, Integer numberRoom, String typeRoom, String facilitie, String service,
                        Integer priceRoom, Integer additionalPriceForOption) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.priceRoom = priceRoom;
        this.additionalPriceForOption = additionalPriceForOption;
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

    public Integer getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(Integer priceRoom) {
        this.priceRoom = priceRoom;
    }

    public Integer getAdditionalPriceForOption() {
        return additionalPriceForOption;
    }

    public void setAdditionalPriceForOption(Integer additionalPriceForOption) {
        this.additionalPriceForOption = additionalPriceForOption;
    }


}
