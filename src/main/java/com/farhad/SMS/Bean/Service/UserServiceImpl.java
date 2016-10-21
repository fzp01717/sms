package com.farhad.SMS.Bean.Service;

import com.farhad.SMS.Interface.DAOinterface.UserDAO;
import com.farhad.SMS.Interface.ServiceInterface.UserService;
import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.DbEntities.UserRolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by FARHAD ZAMAN on 08-May-16.
 */
@PropertySources({
        @PropertySource(value = "classpath:AppProperties/sqlQueryStrings.properties")
})

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {

    @Qualifier("userDAOImpl")
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }

    public Serializable insert(UserLoginEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userDAO.insert(userEntity);
    }

    public void update(UserLoginEntity userEntity) {

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userDAO.update(userEntity);
    }

    public void delete(UserLoginEntity userEntity) {
        userDAO.delete(userEntity);
    }

    public void deleteUsingID(String userId) {
        userDAO.deleteUsingID(userId);
    }

    public UserLoginEntity getById(String userId) {
        return userDAO.getById(userId);
    }

    public Set<?> getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    public Set<?> getAll() {
        return userDAO.getAll();
    }

    public List<UserRolesEntity> getUserRoles(int... type) {
        return userDAO.getUserRoles(type);
    }

    public Set<?> getByUserName(String userName) {
        return userDAO.getByUserName(userName);
    }


    public UserDetails loadUserByUsername(String userLoginString) throws UsernameNotFoundException {

        Set<?> loginEntityByUserName = this.getByUserName(userLoginString);
        Set<?> loginEntityByEmail=this.getByEmail(userLoginString);
        Set<UserLoginEntity> loginEntity = (Set<UserLoginEntity>) (loginEntityByUserName.size() != 0 ? loginEntityByUserName : loginEntityByEmail);
        if (loginEntity != null && loginEntity.size()== 1) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
            String userName= "";
            String password= "";

            for (UserLoginEntity entity:loginEntity) {
                userName=entity.getUserName();
                password=entity.getPassword();
                for (UserRolesEntity rolesEntity: entity.getUserRoles()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(rolesEntity.getRole()));
                }
            }
            return new org.springframework.security.core.userdetails.User(userName, password, grantedAuthorities);
        }

        return null;

    }


}
