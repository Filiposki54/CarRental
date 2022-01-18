package com.pjatk.carrental.repository;

import com.pjatk.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carRepository extends JpaRepository<Car, Long> {
}
