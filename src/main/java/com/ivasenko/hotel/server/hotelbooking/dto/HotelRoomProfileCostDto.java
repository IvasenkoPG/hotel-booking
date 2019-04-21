package com.ivasenko.hotel.server.hotelbooking.dto;

import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.entity.ReservationDate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Class represents Hotel Room Cost Profile dto.
 */
@Component
public class HotelRoomProfileCostDto {

    private Long id;

    private Integer countAdditionalPrice;

    private Integer countPrice;

    private Set<ReservationDate> reservationDate;

    public HotelRoomProfileCostDto() {
    }

    public HotelRoomProfileCostDto(Long id, Integer countAdditionalPrice, Integer countPrice,
                                   Set<ReservationDate> reservationDate) {
        this.id = id;
        this.countAdditionalPrice = countAdditionalPrice;
        this.countPrice = countPrice;
        this.reservationDate = reservationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<ReservationDate> getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Set<ReservationDate> reservationDate) {
        this.reservationDate = reservationDate;
    }
}
