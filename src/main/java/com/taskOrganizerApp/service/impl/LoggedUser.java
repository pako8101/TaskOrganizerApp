package com.taskOrganizerApp.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
@NoArgsConstructor
public class LoggedUser {

    private  String username;

    private boolean isLogged;

    public void  login(String username){
        this.username = username;
        this.isLogged= true;
    }
    public void  logout(){
        this.username = null;
        this.isLogged= false;
    }
}
