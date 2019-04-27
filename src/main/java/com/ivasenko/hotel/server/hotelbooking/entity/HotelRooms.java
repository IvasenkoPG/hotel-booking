package com.ivasenko.hotel.server.hotelbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Class represents HotelRooms entity.
 */

@Entity
@Table
public class HotelRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer numberRoom;


    private String typeRoom;


    private String facilitie;


    private String service;


    private Integer priceRoom;

    private Integer additionalPriceForOption;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelRooms")
    private Set<ReservationHotelRoom> reservationHotelRooms;



    public HotelRooms() {
    }

    public HotelRooms(Integer numberRoom, String typeRoom, String facilitie, String service,
                      Integer priceRoom, Integer additionalPriceForOption,
                      Set<ReservationHotelRoom> reservationHotelRooms) {
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.facilitie = facilitie;
        this.service = service;
        this.priceRoom = priceRoom;
        this.additionalPriceForOption = additionalPriceForOption;
        this.reservationHotelRooms = reservationHotelRooms;
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

    public Set<ReservationHotelRoom> getReservationHotelRooms() {
        return reservationHotelRooms;
    }

    public void setReservationHotelRooms(Set<ReservationHotelRoom> reservationHotelRooms) {
        this.reservationHotelRooms = reservationHotelRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRooms that = (HotelRooms) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(numberRoom, that.numberRoom) &&
                Objects.equals(typeRoom, that.typeRoom) &&
                Objects.equals(facilitie, that.facilitie) &&
                Objects.equals(service, that.service) &&
                Objects.equals(priceRoom, that.priceRoom) &&
                Objects.equals(additionalPriceForOption, that.additionalPriceForOption) &&
                Objects.equals(reservationHotelRooms, that.reservationHotelRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberRoom, typeRoom, facilitie, service, priceRoom, additionalPriceForOption, reservationHotelRooms);
    }

    @Override
    public String toString() {
        return "HotelRooms{" +
                "id=" + id +
                ", numberRoom=" + numberRoom +
                ", typeRoom='" + typeRoom + '\'' +
                ", facilitie='" + facilitie + '\'' +
                ", service='" + service + '\'' +
                ", priceRoom=" + priceRoom +
                ", additionalPriceForOption=" + additionalPriceForOption +
                ", reservationHotelRooms=" + reservationHotelRooms +
                '}';
    }
}
