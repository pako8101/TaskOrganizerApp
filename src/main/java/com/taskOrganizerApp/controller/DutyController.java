package com.taskOrganizerApp.controller;

import com.taskOrganizerApp.model.dto.duty.DutyAddBindingModel;
import com.taskOrganizerApp.service.DutyService;
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
public class DutyController {
    private final DutyService dutyService;
    private final LoggedUser loggedUser;

    @Autowired
    public DutyController(DutyService dutyService, LoggedUser loggedUser) {
        this.dutyService = dutyService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/duties/add")
    public ModelAndView add(@ModelAttribute("dutyAddBindingModel")
                            DutyAddBindingModel dutyAddBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("duty-add");
    }

    @PostMapping("/duties/add")
    public ModelAndView add(@ModelAttribute("dutyAddBindingModel")
                            @Valid DutyAddBindingModel dutyAddBindingModel,
                            BindingResult bindingResult) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("duty-add");
        }
dutyService.add(dutyAddBindingModel);
        return new ModelAndView("redirect:/");
    }

}
