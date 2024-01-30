package com.taskOrganizerApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DutyController {

    @GetMapping("/duties/add")
    public ModelAndView add(){
        return new ModelAndView("task-add");
    }
}
