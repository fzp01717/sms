package com.farhad.SMS.Interface.ServiceInterface;

import com.farhad.SMS.Interface.DAOinterface.RememberMeLogoutHandlerDAO;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by polok on 04-Oct-16.
 */
public interface RememberMeLogoutHandlerService extends RememberMeLogoutHandlerDAO {
    void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication);
}
