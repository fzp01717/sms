package com.farhad.SMS.Model.DbEntities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by FARHAD ZAMAN on 16-Jul-16.
 */
@Entity
@Table(name = "user_roles", schema = "sms")
public class UserRolesEntity {
    private Integer type;
    private String role;
    private Collection<UserLoginEntity> userRoles;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesEntity that = (UserRolesEntity) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    //@JsonIgnore
    @ManyToMany(mappedBy = "userRoles")
    public Collection<UserLoginEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<UserLoginEntity> userRoles) {
        this.userRoles = userRoles;
    }
}
