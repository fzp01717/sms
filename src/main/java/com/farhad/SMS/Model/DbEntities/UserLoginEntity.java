package com.farhad.SMS.Model.DbEntities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by polok on 09-Sep-16.
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "getByEmail",query = "SELECT * FROM `user_profile` up INNER JOIN user_login ul ON ul.profileId = up.profileId INNER JOIN user_password_options po ON po.optionId = ul.passwordOption INNER JOIN user_authentication ua ON ua.userId = ul.userId INNER JOIN user_roles ur ON ua.type = ur.type INNER JOIN user_address uad ON uad.profileId=up.profileId WHERE up.email =:email",resultClass = UserLoginEntity.class),
        @NamedNativeQuery(name = "getByUserName",query = "SELECT * FROM user_login WHERE userName=:userName",resultClass = UserLoginEntity.class),
        @NamedNativeQuery(name = "getAllUser",query = "SELECT * FROM `user_profile` up INNER JOIN user_login ul ON ul.profileId = up.profileId INNER JOIN user_password_options po ON po.optionId = ul.passwordOption INNER JOIN user_authentication ua ON ua.userId = ul.userId INNER JOIN user_roles ur ON ua.type = ur.type INNER JOIN user_address uad ON uad.profileId=up.profileId",resultClass = UserLoginEntity.class)
})
@Entity
@Table(name = "user_login", schema = "sms", catalog = "")
public class UserLoginEntity {
    private int userId;
    private String userName;
    private String password;
    private UserPasswordOptionsEntity userPasswordOptionsByPasswordOption;
    private UserProfileEntity userProfileByProfileId;
    private Collection<UserRolesEntity> userRoles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLoginEntity that = (UserLoginEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_authentication", schema = "sms", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false), inverseJoinColumns = @JoinColumn(name = "type", referencedColumnName = "type", nullable = false))
    public Collection<UserRolesEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserRolesEntity> userRoles) {
        this.userRoles = userRoles;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "passwordOption", referencedColumnName = "optionId", nullable = false)
    public UserPasswordOptionsEntity getUserPasswordOptionsByPasswordOption() {
        return userPasswordOptionsByPasswordOption;
    }

    public void setUserPasswordOptionsByPasswordOption(UserPasswordOptionsEntity userPasswordOptionsByPasswordOption) {
        this.userPasswordOptionsByPasswordOption = userPasswordOptionsByPasswordOption;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "profileId", referencedColumnName = "profileId", nullable = false)
    public UserProfileEntity getUserProfileByProfileId() {
        return userProfileByProfileId;
    }

    public void setUserProfileByProfileId(UserProfileEntity userProfileByProfileId) {
        this.userProfileByProfileId = userProfileByProfileId;
    }
}
