package com.pjatk.carrental.repository;

import com.pjatk.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarById(Long id);
    Optional<Car> findCarByAvailable(Boolean bool);
}
