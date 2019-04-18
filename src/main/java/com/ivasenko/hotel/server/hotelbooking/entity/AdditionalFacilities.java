package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

/**
 * Class represents AdditionalFacilities entity.
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "facilitieName")})
public class AdditionalFacilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String facilitieName;

    @NotBlank
    private Integer price;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "additionalFacilities")
    private Set<HotelRooms> hotelRooms;


    public AdditionalFacilities() {
    }

    public AdditionalFacilities(@NotBlank String facilitieName, @NotBlank Integer price, Set<HotelRooms> hotelRooms) {
        this.facilitieName = facilitieName;
        this.price = price;
        this.hotelRooms = hotelRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilitieName() {
        return facilitieName;
    }

    public void setFacilitieName(String facilitieName) {
        this.facilitieName = facilitieName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<HotelRooms> getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(Set<HotelRooms> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalFacilities that = (AdditionalFacilities) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(facilitieName, that.facilitieName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(hotelRooms, that.hotelRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facilitieName, price, hotelRooms);
    }

    @Override
    public String toString() {
        return "AdditionalFacilities{" +
                "id=" + id +
                ", facilitieName='" + facilitieName + '\'' +
                ", price=" + price +
                ", hotelRooms=" + hotelRooms +
                '}';
    }
}
