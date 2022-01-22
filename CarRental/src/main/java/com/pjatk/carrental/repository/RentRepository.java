package com.pjatk.carrental.repository;

import com.pjatk.carrental.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    Optional<Rent> findById(Long id);
}
