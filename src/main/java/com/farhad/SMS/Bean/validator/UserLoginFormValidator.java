package com.farhad.SMS.Bean.validator;

import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.UserInfoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by FARHAD ZAMAN on 08-Jun-16.
 */
//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class UserLoginFormValidator implements Validator {
    @Autowired
    private Environment environment;

    public boolean supports(Class<?> aClass) {
        return UserInfoViewModel.class.equals(aClass);
    }

    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty.UserLoginForm.userNameOrEmail");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.UserLoginForm.password");

    }
}
