package com.pjatk.carrental.service;

import com.pjatk.carrental.model.User;
import com.pjatk.carrental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    public String singUpUser(User user){
        boolean userExist = userRepository.findByUserName(user.getUsername()).isPresent();
        if(userExist){
            throw new IllegalStateException("Username taken, use different username");
        }
        userRepository.save(user);
        return "";
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getCurrentUser(){
        User currentUser = (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return currentUser;
    }

}
