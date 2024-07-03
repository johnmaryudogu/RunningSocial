package com.Johnmary.MyFitnessApp.controller;

import com.Johnmary.MyFitnessApp.Model.UserModel;
import com.Johnmary.MyFitnessApp.dto.RegisterationDto;
import com.Johnmary.MyFitnessApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegisterationDto user = new RegisterationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegisterationDto user,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        UserModel existingUserEmail = userService.findByEmail(user.getEmail());
        if (existingUserEmail != null) {
            bindingResult.rejectValue("email", "error.user", "There is already a user with this email");
        }

        UserModel existingUserName = userService.findByUsername(user.getUsername());
        if (existingUserName != null) {
            bindingResult.rejectValue("username", "error.user", "There is already a user with this username");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/clubs?success";
    }
}
