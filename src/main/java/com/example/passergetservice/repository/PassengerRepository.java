package com.example.passergetservice.repository;

import com.example.passergetservice.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
