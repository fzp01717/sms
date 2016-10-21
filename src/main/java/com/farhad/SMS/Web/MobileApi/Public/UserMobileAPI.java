package com.farhad.SMS.Web.MobileApi.Public;

import com.farhad.SMS.Interface.ServiceInterface.UserService;
import com.farhad.SMS.Model.DbEntities.UserLoginEntity;
import com.farhad.SMS.Model.UserInfoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by FARHAD ZAMAN on 21-May-16.
 */
@RestController
@PropertySources({
        @PropertySource(value = "classpath:AppProperties/sqlQueryStrings.properties")
})
public class UserMobileAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    private Map<String, Object> json;


    @RequestMapping(value = "/mobile-api/public/user/getUserList")
    public Map<String, Object> getUserList() {
        json =new HashMap<String, Object>();
        List<UserInfoViewModel> userInfoViewModels =new ArrayList<UserInfoViewModel>();

        for (Object loginEntity:userService.getAll()){
            userInfoViewModels.add(new UserInfoViewModel((UserLoginEntity) loginEntity));
        }
        json.put("userList", userInfoViewModels);
        return json;
    }

    /*@RequestMapping(value = "/mobile-api/public/user/getUserById", method = RequestMethod.GET)   //Wrong Method
    public Map<String, Object> getUserById(@RequestParam String userId) {
        json =new HashMap<String, Object>();
        json.put("user",userService.getById(userId));
        return json;
    }
*/
    @RequestMapping(method = RequestMethod.GET, value = "/mobile-api/public/user/getUserByEmail")
    public Map<String, Object> getUserByEmail(HttpSession session, @RequestParam String email) {
        Set<?> userEntities = userService.getByEmail(email);
       // Set<?> userEntitiesNames = userService.getByUserName(environment.getProperty("sql.getUserDataByUserName"),"polok1");

        json = new HashMap<String, Object>();

        json.put("sessionId", session.getId());
        json.put("size", userEntities.size());
        json.put("user",userEntities);
        json.put("error", true);

        return json;
    }
}
