package com.example.passergetservice.controller;

import com.example.passergetservice.entity.Passenger;
import com.example.passergetservice.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private PassengerRepository passengerRepository;
    @GetMapping("/getAll")
    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }

}
