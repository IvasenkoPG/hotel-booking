package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class represents ReservationHotelRoom entity.
 */

@Entity
@Table
public class ReservationHotelRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String startDate;

    private String finishDate;

    private Integer priceRoomCount;

    private Integer additionalPriceForOptionCount;

    @ManyToOne(cascade = CascadeType.ALL)
    private HotelRooms hotelRooms;

    @ManyToOne(cascade = CascadeType.ALL)
    private Profile profiles;

    public ReservationHotelRoom() {
    }

    public ReservationHotelRoom(String startDate, String finishDate, Integer priceRoomCount,
                                Integer additionalPriceForOptionCount, HotelRooms hotelRooms,
                                Profile profiles) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.priceRoomCount = priceRoomCount;
        this.additionalPriceForOptionCount = additionalPriceForOptionCount;
        this.hotelRooms = hotelRooms;
        this.profiles = profiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
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

    public HotelRooms getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(HotelRooms hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public Profile getProfiles() {
        return profiles;
    }

    public void setProfiles(Profile profiles) {
        this.profiles = profiles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationHotelRoom that = (ReservationHotelRoom) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(priceRoomCount, that.priceRoomCount) &&
                Objects.equals(additionalPriceForOptionCount, that.additionalPriceForOptionCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, finishDate, priceRoomCount, additionalPriceForOptionCount);
    }

    @Override
    public String toString() {
        return "ReservationHotelRoom{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", priceRoomCount=" + priceRoomCount +
                ", additionalPriceForOptionCount=" + additionalPriceForOptionCount +
                ", hotelRooms=" + hotelRooms +
                ", profiles=" + profiles +
                '}';
    }
}
