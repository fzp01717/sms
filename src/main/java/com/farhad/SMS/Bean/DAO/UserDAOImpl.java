package com.farhad.SMS.Bean.DAO;

import com.farhad.SMS.Interface.DAOinterface.UserDAO;
import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.DbEntities.UserRolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by FARHAD ZAMAN on 08-May-16.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private Environment environment;

    public Serializable insert(UserLoginEntity userEntity) {
        return hibernateTemplate.save(userEntity);

    }

    public void update(UserLoginEntity userEntity) {
        hibernateTemplate.update(userEntity);
    }


    public void delete(UserLoginEntity userEntity) {
        hibernateTemplate.delete(userEntity);
    }

    public void deleteUsingID(String userId) {
        hibernateTemplate.delete(this.getById(userId));
    }

    public UserLoginEntity getById(String userId) {
        return hibernateTemplate.get(UserLoginEntity.class, userId);
    }

    public Set<?> getByEmail(String email) {
        return new HashSet<Object>(hibernateTemplate.findByNamedQueryAndNamedParam(environment.getProperty("sql.getUserDataByEmail"),"email",email));
    }

    public Set<?> getAll() {
        return new HashSet<Object>(hibernateTemplate.findByNamedQuery(environment.getProperty("sql.getAllUser")));
    }

    public List<UserRolesEntity> getUserRoles(int... type) {
        List<UserRolesEntity> userRolesEntityList =new ArrayList<UserRolesEntity>();
        if (type.length!=0){
            for (int i : type) {
                userRolesEntityList.add(hibernateTemplate.get(UserRolesEntity.class,i));
            }
        }else {
            userRolesEntityList= hibernateTemplate.loadAll(UserRolesEntity.class);
        }

       return userRolesEntityList;
    }

    public Set<?> getByUserName(String userName) {
        return new HashSet<Object>(hibernateTemplate.findByNamedQueryAndNamedParam(environment.getProperty("sql.getUserDataByUserName"),"userName",userName));
    }


}
