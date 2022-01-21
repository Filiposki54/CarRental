package com.pjatk.carrental.controller;

import com.pjatk.carrental.model.RegistrationRequest;
import com.pjatk.carrental.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    private final CarService carService;

    public HomePageController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("user")
    public ResponseEntity user(){
        return ResponseEntity.ok("<h1>Hello User</1>");
    }
    @GetMapping("admin")
    public ResponseEntity admin(){
        return ResponseEntity.ok("<h1>Hello Admin</1>");
    }
    @GetMapping("register")
    public String showRegisterPanel(Model model){
        model.addAttribute("request",new RegistrationRequest());
        return "register";
    }
    @GetMapping("rent_car")
    public String rentCar(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "rent_car";
    }
}
