package com.pjatk.carrental.service;

import com.pjatk.carrental.model.Car;
import com.pjatk.carrental.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    public List<Car> getAllAvailableCars(){
        return carRepository.findCarByAvailable(true);
    }


    public Car getCarById(Long id){
        Car car = carRepository.findCarById(id).get();
        return car;
    }

    public String addCarToRepo(Car car){
        boolean carExist = carRepository.findCarById(car.getId()).isPresent();
        if(carExist){
            throw new IllegalStateException("Car already exist");
        }
        carRepository.save(car);
        return "Working";
    }
}
