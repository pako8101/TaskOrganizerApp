package com.taskOrganizerApp.service;

import com.taskOrganizerApp.model.dto.user.UserLoginBindingModel;
import com.taskOrganizerApp.model.dto.user.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);


    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
