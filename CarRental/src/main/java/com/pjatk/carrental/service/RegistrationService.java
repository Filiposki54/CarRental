package com.pjatk.carrental.service;

import com.pjatk.carrental.model.User;
import com.pjatk.carrental.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    public String register(RegistrationRequest request) {
        return userService.singUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getPassword(),
                "USER"
                )
        );
    }
}
