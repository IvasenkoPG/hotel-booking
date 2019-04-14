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

    public AdditionalServices() {
    }

    public AdditionalServices(@NotBlank String serviceName) {
        this.serviceName = serviceName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalServices that = (AdditionalServices) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName);
    }

    @Override
    public String toString() {
        return "AdditionalServices{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
