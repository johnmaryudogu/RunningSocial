package com.Johnmary.MyFitnessApp.service;

import com.Johnmary.MyFitnessApp.Model.UserModel;
import com.Johnmary.MyFitnessApp.dto.RegisterationDto;

public interface UserService {
    void saveUser(RegisterationDto registerationDto);

    UserModel findByEmail(String email);

    UserModel findByUsername(String username);
}
