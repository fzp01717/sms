package com.farhad.SMS.Model;

import com.farhad.SMS.Model.DbEntities.UserAddressEntity;
import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.DbEntities.UserPasswordOptionsEntity;
import com.farhad.SMS.Model.DbEntities.UserProfileEntity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by polok on 15-Aug-16.
 */

public class UserInfoViewModel {
    private String userName;
    private String password;
    private String userFirstName;
    private String userLastName;
    private String userNickName;
    private Collection<UserAddress> userAddresses;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String image;
    private String gender;
    private String region;
    private String passwordQuestion1;
    private String passwordAns1;
    private String passwordQuestion2;
    private String passwordAns2;

    public UserInfoViewModel() {
    }


    public UserInfoViewModel(UserLoginEntity loginEntity) {
        this.setUserInfo(loginEntity);
    }

    private void setUserInfo(UserLoginEntity loginEntity){
        UserProfileEntity userProfile = loginEntity.getUserProfileByProfileId();
        UserPasswordOptionsEntity userPasswordOptions = loginEntity.getUserPasswordOptionsByPasswordOption();
        this.userName=loginEntity.getUserName();
        this.userFirstName= userProfile.getUserFirstName();
        this.userLastName= userProfile.getUserLastName();
        this.userNickName= userProfile.getUserNickName();
        Collection<UserAddressEntity> userAddressesByProfileId = userProfile.getUserAddressesByProfileId();
        this.userAddresses=new ArrayList<UserAddress>();
        this.setUserAddresses(userAddressesByProfileId);
        this.email= userProfile.getEmail();
        this.homePhone= userProfile.getHomePhone();
        this.mobilePhone= userProfile.getMobilePhone();
        this.image= userProfile.getImage();
        this.gender= userProfile.getGender();
        this.region= userProfile.getRegion();
        this.passwordQuestion1= userPasswordOptions.getPasswordQuestion1();
        this.passwordAns1= userPasswordOptions.getPasswordAns1();
        this.passwordQuestion2= userPasswordOptions.getPasswordQuestion2();
        this.passwordAns2= userPasswordOptions.getPasswordAns2();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getImage() {
        return image;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }

    public String getPasswordQuestion1() {
        return passwordQuestion1;
    }

    public void setPasswordQuestion1(String passwordQuestion1) {
        this.passwordQuestion1 = passwordQuestion1;
    }

    public String getPasswordAns1() {
        return passwordAns1;
    }

    public void setPasswordAns1(String passwordAns1) {
        this.passwordAns1 = passwordAns1;
    }

    public String getPasswordQuestion2() {
        return passwordQuestion2;
    }

    public void setPasswordQuestion2(String passwordQuestion2) {
        this.passwordQuestion2 = passwordQuestion2;
    }

    public String getPasswordAns2() {
        return passwordAns2;
    }

    public void setPasswordAns2(String passwordAns2) {
        this.passwordAns2 = passwordAns2;
    }

    private void setUserAddresses(Collection<UserAddressEntity> userAddressEntities){
        for(UserAddressEntity userAddressEntity:userAddressEntities) {
            this.userAddresses.add(new UserAddress(userAddressEntity));
        }
    }

    public Collection<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    private class UserAddress{
        private String addressLine1;
        private String addressLie2;
        private String city;
        private String zip;
        private String country;

        public UserAddress() {
        }

        UserAddress(UserAddressEntity addressEntity) {
            this.addressLine1=addressEntity.getAddressLine1();
            this.addressLie2=addressEntity.getAddressLie2();
            this.city=addressEntity.getCity();
            this.zip=addressEntity.getZip();
            this.country=addressEntity.getCountry();
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        public String getAddressLie2() {
            return addressLie2;
        }

        public String getCity() {
            return city;
        }

        public String getZip() {
            return zip;
        }

        public String getCountry() {
            return country;
        }
    }
}
