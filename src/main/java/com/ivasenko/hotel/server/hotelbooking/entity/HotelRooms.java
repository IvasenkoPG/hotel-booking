package com.ivasenko.hotel.server.hotelbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
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

    @NotBlank
    private Integer numberRoom;

    @NotBlank
    private String typeRoom;

    @NotBlank
    private String facilitie;

    @NotBlank
    private String service;

    @NotBlank
    private Integer price;

    @NotBlank
    private Integer additionalPrice;

    private Integer countAdditionalPrice;

    private Integer countPrice;

    private Boolean status;

    @OneToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReservationDate> reservationDates = new HashSet<>();



    public HotelRooms() {
    }

    public HotelRooms(@NotBlank Integer numberRoom, @NotBlank String typeRoom, @NotBlank String facilitie,
                      @NotBlank String service, @NotBlank Integer price, @NotBlank Integer additionalPrice,
                      Integer countAdditionalPrice, Integer countPrice, Boolean status, Profile profile,
                      Set<ReservationDate> reservationDates) {
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
        this.reservationDates = reservationDates;
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

    public Set<ReservationDate> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(Set<ReservationDate> reservationDates) {
        this.reservationDates = reservationDates;
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
                Objects.equals(price, that.price) &&
                Objects.equals(additionalPrice, that.additionalPrice) &&
                Objects.equals(countAdditionalPrice, that.countAdditionalPrice) &&
                Objects.equals(countPrice, that.countPrice) &&
                Objects.equals(status, that.status) &&
                Objects.equals(profile, that.profile) &&
                Objects.equals(reservationDates, that.reservationDates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberRoom, typeRoom, facilitie, service, price, additionalPrice, countAdditionalPrice, countPrice, status, profile, reservationDates);
    }

    @Override
    public String toString() {
        return "HotelRooms{" +
                "id=" + id +
                ", numberRoom=" + numberRoom +
                ", typeRoom='" + typeRoom + '\'' +
                ", facilitie='" + facilitie + '\'' +
                ", service='" + service + '\'' +
                ", price=" + price +
                ", additionalPrice=" + additionalPrice +
                ", countAdditionalPrice=" + countAdditionalPrice +
                ", countPrice=" + countPrice +
                ", status=" + status +
                ", profile=" + profile +
                ", reservationDates=" + reservationDates +
                '}';
    }
}
