package com.pjatk.carrental.controller;

import com.pjatk.carrental.model.RegistrationRequest;
import com.pjatk.carrental.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;
    @PostMapping("/process_register")
    public String register(@NotNull RegistrationRequest request){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);
        registrationService.register(request);
        return "register_success";
    }
}
