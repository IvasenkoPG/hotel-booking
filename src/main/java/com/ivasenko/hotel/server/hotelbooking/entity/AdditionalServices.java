package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

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

    public AdditionalServices() {
    }

    public AdditionalServices(@NotBlank String serviceName, @NotBlank Integer price) {
        this.serviceName = serviceName;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalServices that = (AdditionalServices) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, price);
    }

    @Override
    public String toString() {
        return "AdditionalServices{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
