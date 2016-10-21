package com.farhad.SMS.Value;

import org.springframework.context.annotation.Bean;

/**
 * Created by FARHAD ZAMAN on 02-Jun-16.
 */
public class Html {
    private final static String _csrfFormToken="<input type='hidden' name='${_csrf.parameterName}' value='${_csrf.token}'/>";
    private final static String _csrfHeaderToken="<meta name='_csrf' content='${_csrf.token}' /> <meta name='_csrf_header' content='${_csrf.headerName}' />";

    public static String getAuthenticatorFormToken(){
        return _csrfFormToken;
    }

    public static String getAuthenticatorHeaderToken(){
        return _csrfHeaderToken;
    }
}


