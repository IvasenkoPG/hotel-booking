package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

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

    public AdditionalFacilities() {
    }

    public AdditionalFacilities(@NotBlank String facilitieName) {
        this.facilitieName = facilitieName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalFacilities that = (AdditionalFacilities) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(facilitieName, that.facilitieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facilitieName);
    }

    @Override
    public String toString() {
        return "AdditionalFacilities{" +
                "id=" + id +
                ", facilitieName='" + facilitieName + '\'' +
                '}';
    }
}
