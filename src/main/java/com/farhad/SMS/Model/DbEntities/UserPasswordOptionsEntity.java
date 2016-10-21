package com.farhad.SMS.Model.DbEntities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by FARHAD ZAMAN on 17-Jul-16.
 */
@Entity
@Table(name = "user_password_options", schema = "sms", catalog = "")
public class UserPasswordOptionsEntity {
    private Integer optionId;
    private String passwordQuestion1;
    private String passwordAns1;
    private String passwordQuestion2;
    private String passwordAns2;
    private String requestId;
    private String createDate;
    private String modifedDate;
    private Collection<UserLoginEntity> userLoginsByOptionId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "optionId")
    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    @Basic
    @Column(name = "passwordQuestion1")
    public String getPasswordQuestion1() {
        return passwordQuestion1;
    }

    public void setPasswordQuestion1(String passwordQuestion1) {
        this.passwordQuestion1 = passwordQuestion1;
    }

    @Basic
    @Column(name = "passwordAns1")
    public String getPasswordAns1() {
        return passwordAns1;
    }

    public void setPasswordAns1(String passwordAns1) {
        this.passwordAns1 = passwordAns1;
    }

    @Basic
    @Column(name = "passwordQuestion2")
    public String getPasswordQuestion2() {
        return passwordQuestion2;
    }

    public void setPasswordQuestion2(String passwordQuestion2) {
        this.passwordQuestion2 = passwordQuestion2;
    }

    @Basic
    @Column(name = "passwordAns2")
    public String getPasswordAns2() {
        return passwordAns2;
    }

    public void setPasswordAns2(String passwordAns2) {
        this.passwordAns2 = passwordAns2;
    }

    @Basic
    @Column(name = "requestId")
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "createDate")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "modifedDate")
    public String getModifedDate() {
        return modifedDate;
    }

    public void setModifedDate(String modifedDate) {
        this.modifedDate = modifedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPasswordOptionsEntity that = (UserPasswordOptionsEntity) o;

        if (optionId != null ? !optionId.equals(that.optionId) : that.optionId != null) return false;
        if (passwordQuestion1 != null ? !passwordQuestion1.equals(that.passwordQuestion1) : that.passwordQuestion1 != null)
            return false;
        if (passwordAns1 != null ? !passwordAns1.equals(that.passwordAns1) : that.passwordAns1 != null) return false;
        if (passwordQuestion2 != null ? !passwordQuestion2.equals(that.passwordQuestion2) : that.passwordQuestion2 != null)
            return false;
        if (passwordAns2 != null ? !passwordAns2.equals(that.passwordAns2) : that.passwordAns2 != null) return false;
        if (requestId != null ? !requestId.equals(that.requestId) : that.requestId != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (modifedDate != null ? !modifedDate.equals(that.modifedDate) : that.modifedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = optionId != null ? optionId.hashCode() : 0;
        result = 31 * result + (passwordQuestion1 != null ? passwordQuestion1.hashCode() : 0);
        result = 31 * result + (passwordAns1 != null ? passwordAns1.hashCode() : 0);
        result = 31 * result + (passwordQuestion2 != null ? passwordQuestion2.hashCode() : 0);
        result = 31 * result + (passwordAns2 != null ? passwordAns2.hashCode() : 0);
        result = 31 * result + (requestId != null ? requestId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifedDate != null ? modifedDate.hashCode() : 0);
        return result;
    }

   // @JsonIgnore
    @OneToMany(mappedBy = "userPasswordOptionsByPasswordOption")
    public Collection<UserLoginEntity> getUserLoginsByOptionId() {
        return userLoginsByOptionId;
    }

    public void setUserLoginsByOptionId(Collection<UserLoginEntity> userLoginsByOptionId) {
        this.userLoginsByOptionId = userLoginsByOptionId;
    }
}
