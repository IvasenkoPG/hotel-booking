package com.ivasenko.hotel.server.hotelbooking.dto;

import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.entity.ReservationDate;

import java.util.Set;

/**
 * Class represents Hotel Room Profile dto.
 */

public class HotelRoomProfileDto {

    private Long id;

    private Integer numberRoom;

    private String typeRoom;

    private String facilitie;

    private String service;

    private Integer price;

    private Integer additionalPrice;

    private Integer countAdditionalPrice;

    private Integer countPrice;

    private Boolean status;

    private Profile profile;

    private Set<ReservationDate> reservationDate;

    public HotelRoomProfileDto() {
    }

    public HotelRoomProfileDto(Long id, Integer numberRoom, String typeRoom, String facilitie,
                               String service, Integer price, Integer additionalPrice,
                               Integer countAdditionalPrice, Integer countPrice, Boolean status) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.price = price;
        this.additionalPrice = additionalPrice;
        this.countAdditionalPrice = countAdditionalPrice;
        this.countPrice = countPrice;
        this.status = status;
    }

    public HotelRoomProfileDto(Long id, Integer numberRoom, String typeRoom, String facilitie, String service,
                               Integer price, Integer additionalPrice, Integer countAdditionalPrice,
                               Integer countPrice, Boolean status, Profile profile) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.price = price;
        this.additionalPrice = additionalPrice;
        this.countAdditionalPrice = countAdditionalPrice;
        this.countPrice = countPrice;
        this.status = status;
        this.profile = profile;
    }

    public HotelRoomProfileDto(Long id, Integer numberRoom, String typeRoom, String facilitie, String service,
                               Integer price, Integer additionalPrice, Integer countAdditionalPrice, Integer countPrice,
                               Boolean status, Set<ReservationDate> reservationDate) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.price = price;
        this.additionalPrice = additionalPrice;
        this.countAdditionalPrice = countAdditionalPrice;
        this.countPrice = countPrice;
        this.status = status;
        this.reservationDate = reservationDate;
    }



    public HotelRoomProfileDto(Long id, Integer numberRoom, String typeRoom, String facilitie, String service,
                               Integer price, Integer additionalPrice, Integer countAdditionalPrice, Integer countPrice,
                               Boolean status, Profile profile, Set<ReservationDate> reservationDate) {
        this.id = id;
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.price = price;
        this.additionalPrice = additionalPrice;
        this.countAdditionalPrice = countAdditionalPrice;
        this.countPrice = countPrice;
        this.status = status;
        this.profile = profile;
        this.reservationDate = reservationDate;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(Integer additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public Integer getCountAdditionalPrice() {
        return countAdditionalPrice;
    }

    public void setCountAdditionalPrice(Integer countAdditionalPrice) {
        this.countAdditionalPrice = countAdditionalPrice;
    }

    public Integer getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(Integer countPrice) {
        this.countPrice = countPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<ReservationDate> getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Set<ReservationDate> reservationDate) {
        this.reservationDate = reservationDate;
    }
}
