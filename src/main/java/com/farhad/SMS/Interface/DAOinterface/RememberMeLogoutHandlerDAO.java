package com.farhad.SMS.Interface.DAOinterface;

import com.farhad.SMS.Model.DbEntities.PersistentLoginsEntity;

/**
 * Created by polok on 03-Oct-16.
 */
public interface RememberMeLogoutHandlerDAO {
    void deleteUsingSeries(PersistentLoginsEntity persistentLoginsEntity);

}
