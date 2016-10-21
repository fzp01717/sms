package com.farhad.SMS.Web.WebApi.Public;

import com.farhad.SMS.Interface.ServiceInterface.UserService;
import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.UserInfoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by FARHAD ZAMAN on 19-Jun-16.
 */
@RestController
@RequestMapping(value = "/public/user/api/")
public class UserApi {

    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    private Map<String, Object> json;


    @RequestMapping(value = "getUserList",produces ="application/json")
    public Map<String, Object> getUserList() {
        json =new HashMap<String, Object>();
        List<UserInfoViewModel> userInfoViewModels =new ArrayList<UserInfoViewModel>();

        for (Object loginEntity:userService.getAll()){
            userInfoViewModels.add(new UserInfoViewModel((UserLoginEntity) loginEntity));
        }
        json.put("userList", userInfoViewModels);
        return json;
    }

    @RequestMapping(value = "getUserInfo",produces = "application/json")
    public Map<String, Object> getUserInfo(String userName) {
        json =new HashMap<String, Object>();
        List<UserLoginEntity> loginEntity=new ArrayList<UserLoginEntity>((Collection<? extends UserLoginEntity>) userService.getByUserName(userName));

        json.put("userInfo",null);
        if (loginEntity.size()==1) {
            UserInfoViewModel userInfoViewModel = new UserInfoViewModel(loginEntity.get(0));
            json.put("userInfo",userInfoViewModel);
        }

        return json;
    }
}
