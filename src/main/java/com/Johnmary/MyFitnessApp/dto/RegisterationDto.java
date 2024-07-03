package com.Johnmary.MyFitnessApp.dto;

import com.Johnmary.MyFitnessApp.Model.UserModel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterationDto {


    @NotEmpty
    private  String username ;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;


}
