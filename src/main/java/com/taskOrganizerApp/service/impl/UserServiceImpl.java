package com.taskOrganizerApp.service.impl;

import com.taskOrganizerApp.model.dto.user.UserLoginBindingModel;
import com.taskOrganizerApp.model.dto.user.UserRegisterBindingModel;
import com.taskOrganizerApp.model.entity.User;
import com.taskOrganizerApp.repo.UserRepository;
import com.taskOrganizerApp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }


        boolean existByUsernameOrEmail = this.userRepository.existsByUsernameOrEmail(userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getEmail());
        if (existByUsernameOrEmail) {
            return false;
        }
        User user = new User();

        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));


        userRepository.save(user);


        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
String username = userLoginBindingModel.getUsername();

User user = userRepository.findByUsername(username);
if (user!= null && passwordEncoder.matches(userLoginBindingModel.getPassword(),
        user.getPassword())){
    loggedUser.login(username);
    return  true;
        }


        return false;
    }

    @Override
    public void logout() {
       this.loggedUser.logout();
    }

}
