package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

/**
 * Class represents AdditionalServices entity.
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "serviceName")})
public class AdditionalServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String serviceName;

    @NotBlank
    private Integer price;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "additionalServices")
    private Set<HotelRooms> hotelRooms;

    public AdditionalServices() {
    }

    public AdditionalServices(@NotBlank String serviceName, @NotBlank Integer price, Set<HotelRooms> hotelRooms) {
        this.serviceName = serviceName;
        this.price = price;
        this.hotelRooms = hotelRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
        AdditionalServices that = (AdditionalServices) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(hotelRooms, that.hotelRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, price, hotelRooms);
    }

    @Override
    public String toString() {
        return "AdditionalServices{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                ", hotelRooms=" + hotelRooms +
                '}';
    }
}
