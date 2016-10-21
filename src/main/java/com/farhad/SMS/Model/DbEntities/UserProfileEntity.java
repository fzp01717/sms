package com.farhad.SMS.Model.DbEntities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by polok on 09-Sep-16.
 */
@Entity
@Table(name = "user_profile", schema = "sms", catalog = "")
public class UserProfileEntity {
    private String userFirstName;
    private String userLastName;
    private String userNickName;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String image;
    private String gender;
    private String region;
    private String createDate;
    private Collection<UserLoginEntity> userLoginsByProfileId;
    private Collection<UserAddressEntity> userAddressesByProfileId;
    private int profileId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profileId")
    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    @Basic
    @Column(name = "userFirstName")
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Basic
    @Column(name = "userLastName")
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "userNickName")
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "homePhone")
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "mobilePhone")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "createDate")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfileEntity that = (UserProfileEntity) o;

        if (userFirstName != null ? !userFirstName.equals(that.userFirstName) : that.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(that.userLastName) : that.userLastName != null) return false;
        if (userNickName != null ? !userNickName.equals(that.userNickName) : that.userNickName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userFirstName != null ? userFirstName.hashCode() : 0;
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userNickName != null ? userNickName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userProfileByProfileId")
    public Collection<UserLoginEntity> getUserLoginsByProfileId() {
        return userLoginsByProfileId;
    }

    public void setUserLoginsByProfileId(Collection<UserLoginEntity> userLoginsByProfileId) {
        this.userLoginsByProfileId = userLoginsByProfileId;
    }

    @OneToMany(mappedBy = "userProfileByProfileId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Collection<UserAddressEntity> getUserAddressesByProfileId() {
        return userAddressesByProfileId;
    }

    public void setUserAddressesByProfileId(Collection<UserAddressEntity> userAddressesByProfileId) {
        this.userAddressesByProfileId = userAddressesByProfileId;
    }


}
