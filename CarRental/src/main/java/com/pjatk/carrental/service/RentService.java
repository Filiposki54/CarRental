package com.pjatk.carrental.service;

import com.pjatk.carrental.model.Rent;
import com.pjatk.carrental.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentService {
    private final RentRepository repository;
    private final CarService carService;
    private final UserService userService;

    public RentService(RentRepository repository, CarService carService, UserService userService) {
        this.repository = repository;
        this.carService = carService;
        this.userService = userService;
    }
    public void create(Long id){
        Rent rent = new Rent();
        rent.setRent_date(new Date());
        rent.setUser(userService.getCurrentUser());
        rent.setCar(carService.getCarById(id));
        carService.serCarAsUnavailable(id);
        repository.save(rent);


    }
    public List<Rent> getRents(){
        return repository.findAll();
    }

}
