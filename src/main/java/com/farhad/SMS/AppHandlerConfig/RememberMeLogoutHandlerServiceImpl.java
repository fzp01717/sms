package com.farhad.SMS.AppHandlerConfig;

import com.farhad.SMS.Interface.DAOinterface.RememberMeLogoutHandlerDAO;
import com.farhad.SMS.Interface.ServiceInterface.RememberMeLogoutHandlerService;
import com.farhad.SMS.Model.DbEntities.PersistentLoginsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by polok on 03-Oct-16.
 */
@Service
@Transactional
public class RememberMeLogoutHandlerServiceImpl extends PersistentTokenBasedRememberMeServices implements RememberMeLogoutHandlerService {

    @Qualifier("rememberMeLogoutHandlerDAOImpl")
    @Autowired
    private RememberMeLogoutHandlerDAO rememberMeLogoutHandlerDAO;

    public RememberMeLogoutHandlerServiceImpl(String key, UserDetailsService userDetailsService, PersistentTokenRepository tokenRepository) {
        super(key, userDetailsService, tokenRepository);
    }


    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        String cookieValue=this.extractRememberMeCookie(request);
        String[] cookieTokens=this.decodeCookie(cookieValue);
        String presentedSeries = cookieTokens[0];
        String presentedToken = cookieTokens[1];
        if(authentication != null) {

            this.deleteUsingSeries(new PersistentLoginsEntity(authentication.getName(),presentedSeries,presentedToken));
        }

        HttpSession context = request.getSession(false);
        if(context != null) {
            this.logger.debug("Invalidating session: " + context.getId());
            context.invalidate();
        }
        super.logout(request, response, null);
    }

    public void deleteUsingSeries(PersistentLoginsEntity persistentLoginsEntity) {
        rememberMeLogoutHandlerDAO.deleteUsingSeries(persistentLoginsEntity);
    }
}
