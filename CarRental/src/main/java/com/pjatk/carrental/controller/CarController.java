package com.pjatk.carrental.controller;

import com.pjatk.carrental.model.Car;
import com.pjatk.carrental.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("carList")
    public List<Car> getCars(){
        return carService.getAllAvailableCars();
    }
    @GetMapping("Car/{id}")
    public Car getCar(@PathVariable long id){
        return carService.getCarById(id);
    }
    @PostMapping("addCar")
    public void addCar(@RequestBody Car car){
        carService.addCarToRepo(car);
    }
}
