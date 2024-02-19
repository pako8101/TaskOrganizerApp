package com.taskOrganizerApp.controller;

import com.taskOrganizerApp.model.dto.duty.DutyHomeViewModel;
import com.taskOrganizerApp.service.DutyService;
import com.taskOrganizerApp.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final DutyService dutyService;
private final LoggedUser loggedUser;
    public HomeController(DutyService dutyService, LoggedUser loggedUser) {
        this.dutyService = dutyService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("index");
    }
    @GetMapping("/home")
    public ModelAndView home(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
      DutyHomeViewModel vieModel = dutyService.getHomeViewData(loggedUser.getUsername());
        return new ModelAndView("home","duties", vieModel);
    }
}
