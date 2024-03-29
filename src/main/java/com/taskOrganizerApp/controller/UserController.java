package com.taskOrganizerApp.controller;

import com.taskOrganizerApp.model.dto.user.UserLoginBindingModel;
import com.taskOrganizerApp.model.dto.user.UserRegisterBindingModel;
import com.taskOrganizerApp.service.UserService;
import com.taskOrganizerApp.service.impl.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;
@Autowired
    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
    this.loggedUser = loggedUser;
}

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                              UserLoginBindingModel userLoginBindingModel){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                                  @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("login");
        }

        boolean hasSuccessfulLogin =    userService.login(userLoginBindingModel);

        if (!hasSuccessfulLogin){
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);

            return  modelAndView;
        }

        return new ModelAndView("redirect:/home");

    }
    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                      UserRegisterBindingModel userRegisterBindingModel){
        return new ModelAndView("register");
    }
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                     @Valid UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("register");
        }

     boolean hasSuccessfulRegistration =    userService.register(userRegisterBindingModel);

        if (!hasSuccessfulRegistration){
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegistrationError", true);

            return  modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }
    @PostMapping("/logout")
    public ModelAndView logout(){
    if (!loggedUser.isLogged()){
        return new ModelAndView("redirect:/home");
    }
    this.userService.logout();
    return new ModelAndView("redirect:/");
    }
}
