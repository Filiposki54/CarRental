package com.pjatk.carrental.controller;

import com.pjatk.carrental.model.Rent;
import com.pjatk.carrental.model.User;
import com.pjatk.carrental.service.CarService;
import com.pjatk.carrental.service.RentService;
import com.pjatk.carrental.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentController {
    private final RentService rentService;


    public RentController(UserService userService, CarService carService, RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/rent")
    public List<Rent> confirmRentCar(){
       return rentService.getRents();
    }
    @PostMapping("/rent")
    public void rentCar(@RequestParam(value = "id", required = true) Long id, Model model){
        model.addAttribute("id", id);
        rentService.create(id);
    }

}
