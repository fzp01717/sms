package com.farhad.SMS.Web.WebApi.Admin;

import com.farhad.SMS.Interface.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by polok on 14-Aug-16.
 */
@RestController
@RequestMapping(value = "/admin/api/")
public class AdminApi {
    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;
    private Map<String, Object> json;


    @RequestMapping(value = "getUserList")
    public Map<String, Object> getUserList() {
        json =new HashMap<String, Object>();
        json.put("userList",userService.getAll());
        return json;
    }
}
