package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.Set;

/**
 * Class represents Profile entity.
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "passport"),
                            @UniqueConstraint(columnNames = "email")
})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String lastName;


    private String firstName;


    private String passport;

    @Email
    private String email;


    private String address;


    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profiles")
    private Set<ReservationHotelRoom> reservationHotelRooms;

    public Profile() {
    }

    public Profile( String lastName,  String firstName,  String passport,
                    String email,  String address,  String telephone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.passport = passport;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(passport, profile.passport) &&
                Objects.equals(email, profile.email) &&
                Objects.equals(address, profile.address) &&
                Objects.equals(telephone, profile.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, passport, email, address, telephone);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
