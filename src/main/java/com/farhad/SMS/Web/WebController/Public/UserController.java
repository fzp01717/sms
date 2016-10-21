package com.farhad.SMS.Web.WebController.Public;

import com.farhad.SMS.Bean.validator.UserFormValidator;
import com.farhad.SMS.Bean.validator.UserLoginFormValidator;
import com.farhad.SMS.Enum.UserRoles;
import com.farhad.SMS.Interface.ServiceInterface.RememberMeLogoutHandlerService;
import com.farhad.SMS.Interface.ServiceInterface.UserService;
import com.farhad.SMS.Model.DbEntities.*;
import com.farhad.SMS.Model.UserInfoViewModel;
import com.farhad.SMS.Value.Html;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by FARHAD ZAMAN on 08-May-16.
 */
@Controller
@PropertySources({
        @PropertySource(value = "classpath:AppProperties/Validation.properties")
})
@RequestMapping(value = "/public/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginFormValidator userLoginFormValidator;
    @Autowired
    private UserFormValidator userFormValidator;
    @Autowired
    private Environment environment;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RememberMeLogoutHandlerService rememberMeLogoutHandlerService;

   /* @InitBinder("userLogin")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userFormValidator, userLoginFormValidator);
    }*/

   /* @RequestMapping(value = "/")
    public String Index() {
        return "index";
    }*/

    @RequestMapping(method = RequestMethod.GET,value = "index")
    public String Index(){

        return "redirect:/public/user/welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String LoginIndex(ModelMap modelMap, String error, String logout, HttpSession session) {

        Object alreadyLogin=session.getAttribute("login");

        if (alreadyLogin != null && Boolean.valueOf(alreadyLogin.toString())) {
            return "redirect:/public/user/welcome";
        }

        if(error!=null){
            modelMap.addAttribute("Error", environment.getProperty("MissMatch.UserLoginForm.Data"));
        }
        if(logout!=null){
            modelMap.addAttribute("LogOut",environment.getProperty("Success.Logout"));

        }
        modelMap.addAttribute("UserInfoViewModel", new UserInfoViewModel());
        return "pages/login";
    }

    @RequestMapping(method = RequestMethod.POST,value = "logout")
    public String Logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
        rememberMeLogoutHandlerService.logout(request,response,authentication);
        return "redirect:/public/user/login?logout";
    }

   /* @RequestMapping(method = RequestMethod.POST, value = "/web/user/login")
    public ModelAndView Login(ModelAndView modelAndView, HttpSession session, @ModelAttribute("userLogin") @Validated(UserLoginFormValidator.class) UserLoginEntity user,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
          modelAndView.setViewName("pages/login");
          return modelAndView;
        }

            modelAndView.setViewName("pages/userWelcome");

            *//*UserLoginEntity loginEntity = userService.getById(user.getUserId());
            StrongPasswordEncryptor passwordEncryption = new StrongPasswordEncryptor();

            if (loginEntity != null && passwordEncryption.checkPassword(user.getPassword(), loginEntity.getPassword())) {
                if ( == 2) {
                    session.setAttribute("userId", user.getUserId());
                    session.setAttribute("userName", loginEntity.getUserProfileByUserId().getUserName());
                    modelAndView.addObject("userId", session.getAttribute("userName").toString());
                    modelAndView.addObject("userList", userService.getAll());

                } else {

                }
            } else {
                modelAndView.addObject("userId", user.getUserId());
                modelAndView.addObject("userLogin", new UserLoginEntity());
                modelAndView.addObject("Error", environment.getProperty("MissMatch.UserLoginForm.Data"));
                modelAndView.setViewName("pages/login");
            }*//*

        return modelAndView;
    }*/

    @RequestMapping(method = RequestMethod.GET,value = "welcome")
    public ModelAndView welcome(ModelAndView modelAndView, Authentication authentication,HttpSession session)
    {
        modelAndView.setViewName("pages/userWelcome");
        if(authentication!=null) {
            modelAndView.addObject("userName", authentication.getName());
            session.setAttribute("login",true);
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "insert")
    public ModelAndView insert(ModelAndView modelAndView){
        //StrongPasswordEncryptor passwordEncryption = new StrongPasswordEncryptor();

        UserLoginEntity loginEntity =new UserLoginEntity();
        UserProfileEntity profileEntity =new UserProfileEntity();
        UserPasswordOptionsEntity passwordOptionsEntity =new UserPasswordOptionsEntity();
        UserAddressEntity userAddress1=new UserAddressEntity();
        UserAddressEntity userAddress2=new UserAddressEntity();
        UserAddressEntity userAddress3=new UserAddressEntity();
        UserRolesEntity rolesEntity1= new UserRolesEntity();
        UserRolesEntity rolesEntity2= new UserRolesEntity();

        Collection<UserAddressEntity> addressEntities =new ArrayList<UserAddressEntity>();

        userAddress1.setAddressLine1("munshipara");
        userAddress1.setCity("dinajpur");
        userAddress1.setCountry("Bangladesh");
        userAddress1.setZip("2004");
        userAddress1.setUserProfileByProfileId(profileEntity);

        userAddress2.setAddressLine1("munshipara");
        userAddress2.setCity("dinajpur");
        userAddress2.setCountry("Bangladesh");
        userAddress2.setZip("2005");
        userAddress2.setUserProfileByProfileId(profileEntity);

        userAddress3.setAddressLine1("munshipara");
        userAddress3.setCity("dinajpur");
        userAddress3.setCountry("Bangladesh");
        userAddress3.setZip("2006");
        userAddress3.setUserProfileByProfileId(profileEntity);

        addressEntities.add(userAddress1);
        addressEntities.add(userAddress2);
        addressEntities.add(userAddress3);

        rolesEntity1.setRole(UserRoles.ROLE_ADMIN.toString());
        rolesEntity1.setType(UserRoles.ROLE_ADMIN.getValue());

        rolesEntity2.setRole(UserRoles.ROLE_USER.toString());
        rolesEntity2.setType(UserRoles.ROLE_USER.getValue());

        Collection<UserRolesEntity> userRoles=new ArrayList<UserRolesEntity>();

        userRoles.add(rolesEntity1);
        userRoles.add(rolesEntity2);

        //String userId="polok1";
        String email="polok1@polok1.com";
        String userName="polok2";
        String password="1234";

        profileEntity.setEmail(email);
        profileEntity.setUserFirstName(userName);
        profileEntity.setUserAddressesByProfileId(addressEntities);
        /*Collection<UserProfileEntity> userProfileEntities =new ArrayList<UserProfileEntity>();
        userProfileEntities.add(profileEntity);*/

        loginEntity.setUserName(userName);
        loginEntity.setPassword(password);
        loginEntity.setUserPasswordOptionsByPasswordOption(passwordOptionsEntity);
        loginEntity.setUserProfileByProfileId(profileEntity);
        //loginEntity.setUserRoles(userService.getUserRoles(UserRoles.ROLE_USER.getValue()));
        loginEntity.setUserRoles(userRoles);


        //authenticationEntity.setUserId(loginEntity.getUserId());
       // profileEntity.setUserId(loginEntity.getUserId());
       // passwordOptionsEntity.setUserId(loginEntity.getUserId());

        userService.insert(loginEntity);

       // Set<UserLoginEntity> userEntitiesNames = (Set<UserLoginEntity>) userService.getByUserName(environment.getProperty("sql.getUserDataByUserName"),"polok1");

        //Boolean res=passwordEncoder.matches(password,userEntitiesNames.iterator().next().getPassword());

        modelAndView.setViewName("redirect:/public/user/login");

        return modelAndView;
    }

}
