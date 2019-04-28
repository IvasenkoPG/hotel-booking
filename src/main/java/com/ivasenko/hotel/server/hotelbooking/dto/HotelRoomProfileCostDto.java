package com.ivasenko.hotel.server.hotelbooking.dto;

import com.ivasenko.hotel.server.hotelbooking.entity.ReservationHotelRoom;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Class represents Hotel Room Cost Profile dto.
 */
@Component
public class HotelRoomProfileCostDto {

    private Long id;

    private Integer additionalPriceForOptionCount;

    private Integer priceRoomCount;;

    private Integer totalRoom;

    public HotelRoomProfileCostDto() {
    }

    public HotelRoomProfileCostDto(Long id, Integer additionalPriceForOptionCount, Integer priceRoomCount,
                                   Integer totalRoom) {
        this.id = id;
        this.additionalPriceForOptionCount = additionalPriceForOptionCount;
        this.priceRoomCount = priceRoomCount;
        this.totalRoom = totalRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAdditionalPriceForOptionCount() {
        return additionalPriceForOptionCount;
    }

    public void setAdditionalPriceForOptionCount(Integer additionalPriceForOptionCount) {
        this.additionalPriceForOptionCount = additionalPriceForOptionCount;
    }

    public Integer getPriceRoomCount() {
        return priceRoomCount;
    }

    public void setPriceRoomCount(Integer priceRoomCount) {
        this.priceRoomCount = priceRoomCount;
    }

    public Integer getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(Integer totalRoom) {
        this.totalRoom = totalRoom;
    }
}
