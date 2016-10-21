package com.farhad.SMS.Model.DbEntities;

import javax.persistence.*;

/**
 * Created by polok on 09-Sep-16.
 */
@Entity
@Table(name = "user_address", schema = "sms", catalog = "")
public class UserAddressEntity {
    private int addressId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zip;
    private String country;
    private UserProfileEntity userProfileByProfileId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Basic
    @Column(name = "addressLine2")
    public String getAddressLie2() {
        return addressLine2;
    }

    public void setAddressLie2(String addressLie2) {
        this.addressLine2 = addressLie2;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAddressEntity that = (UserAddressEntity) o;

        if (addressId != that.addressId) return false;
        if (addressLine1 != null ? !addressLine1.equals(that.addressLine1) : that.addressLine1 != null) return false;
        if (addressLine2 != null ? !addressLine2.equals(that.addressLine2) : that.addressLine2 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (zip != null ? !zip.equals(that.zip) : that.zip != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "profileId", referencedColumnName = "profileId", nullable = false)
    public UserProfileEntity getUserProfileByProfileId() {
        return userProfileByProfileId;
    }

    public void setUserProfileByProfileId(UserProfileEntity userProfileByProfileId) {
        this.userProfileByProfileId = userProfileByProfileId;
    }
}
