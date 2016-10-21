package com.farhad.SMS.Bean.validator;

import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.UserInfoViewModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by FARHAD ZAMAN on 08-Jun-16.
 */
@Component
public class UserFormValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return UserInfoViewModel.class.equals(aClass);
    }

    public void validate(Object target, Errors errors) {



    }
}
