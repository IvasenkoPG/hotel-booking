package com.ivasenko.hotel.server.hotelbooking.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    private Integer countPrice;

    private Boolean status;

    private String startDate;

    private String finishDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "hotelRooms_profiles", joinColumns = @JoinColumn(name = "hotelRooms_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    @JoinColumn(name = "hotelRooms_id")
    private Set<Profile> profiles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotelRooms_additionalFacilities", joinColumns = @JoinColumn(name = "hotelRooms_id"),
            inverseJoinColumns = @JoinColumn(name = "additionalFacilitie_id")
    )
    private Set<AdditionalFacilities> additionalFacilities;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hotelRooms_additionalServices", joinColumns = @JoinColumn(name = "hotelRooms_id"),
            inverseJoinColumns = @JoinColumn(name = "additionalService_id")
    )
    private Set<AdditionalServices> additionalServices;

    public HotelRooms() {
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

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

    public Set<AdditionalFacilities> getAdditionalFacilities() {
        return additionalFacilities;
    }

    public void setAdditionalFacilities(Set<AdditionalFacilities> additionalFacilities) {
        this.additionalFacilities = additionalFacilities;
    }

    public Set<AdditionalServices> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(Set<AdditionalServices> additionalServices) {
        this.additionalServices = additionalServices;
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
                Objects.equals(countPrice, that.countPrice) &&
                Objects.equals(status, that.status) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(profiles, that.profiles) &&
                Objects.equals(additionalFacilities, that.additionalFacilities) &&
                Objects.equals(additionalServices, that.additionalServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberRoom, typeRoom, facilitie, service, price, countPrice, status, startDate, finishDate, profiles, additionalFacilities, additionalServices);
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
                ", countPrice=" + countPrice +
                ", status=" + status +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", profiles=" + profiles +
                ", additionalFacilities=" + additionalFacilities +
                ", additionalServices=" + additionalServices +
                '}';
    }
}
