package com.Johnmary.MyFitnessApp.impl;

import com.Johnmary.MyFitnessApp.Model.Role;
import com.Johnmary.MyFitnessApp.Model.UserModel;
import com.Johnmary.MyFitnessApp.Repository.RoleRepository;
import com.Johnmary.MyFitnessApp.Repository.UserRepository;
import com.Johnmary.MyFitnessApp.dto.RegisterationDto;
import com.Johnmary.MyFitnessApp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {



    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegisterationDto registerationDto) {

        UserModel userModel = new UserModel();
        userModel.setUsername(registerationDto.getUsername());
        userModel.setEmail(registerationDto.getEmail());
        userModel.setPassword(registerationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        userModel.setRoles(Collections.singletonList(role));
        userRepository.save(userModel);
    }

    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
