package com.farhad.SMS.Interface.DAOinterface;

import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.DbEntities.UserRolesEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by FARHAD ZAMAN on 08-May-16.
 */
public interface UserDAO {
    Serializable insert(UserLoginEntity userEntity);

    void update(UserLoginEntity userEntity);

    void delete(UserLoginEntity userEntity);

    void deleteUsingID(String userId);

    UserLoginEntity getById(String userId);

    Set<?> getByEmail(String email);

    Set<?> getByUserName(String userName);

    Set<?> getAll();

    List<UserRolesEntity> getUserRoles(int... type);


}
