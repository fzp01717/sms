package com.farhad.SMS.Bean.DAO;

import com.farhad.SMS.Interface.DAOinterface.RememberMeLogoutHandlerDAO;
import com.farhad.SMS.Model.DbEntities.PersistentLoginsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by polok on 03-Oct-16.
 */
@Repository
public class RememberMeLogoutHandlerDAOImpl implements RememberMeLogoutHandlerDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void deleteUsingSeries(PersistentLoginsEntity persistentLoginsEntity) {
        hibernateTemplate.delete(persistentLoginsEntity);
    }
}
