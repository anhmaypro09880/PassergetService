package com.example.passergetservice.controller;

import com.example.passergetservice.entity.Passenger;
import com.example.passergetservice.repository.PassengerRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private RestTemplate restTemplate;

    public static final String PASSENGER_SERVICE="passengerService";
    private int count=1;
    private int attempt=1;
    @Autowired
    private PassengerRepository passengerRepository;
    @GetMapping("/getAll")
    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }
    @GetMapping("/retryPassenger")
    @Retry(name = PASSENGER_SERVICE)
    public String displayOrders() {

        if (count<10){
            count++;
            System.out.println("Fail :"+count);
            return restTemplate.getForObject("http://localhost:9292/user-service/test1111", String.class);
        }
        else{
            count=1;
            System.out.println("Successfully :" + count);
            attempt=1;
            return restTemplate.getForObject("http://localhost:8082/getAll", String.class);
        }
    }


}
