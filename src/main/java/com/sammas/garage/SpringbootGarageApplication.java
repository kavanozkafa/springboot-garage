package com.sammas.garage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.sammas.garage.service.ParkService;

@SpringBootApplication
@EnableCaching
public class SpringbootGarageApplication {

    @Autowired
    ParkService parkService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootGarageApplication.class, args);
	}

}