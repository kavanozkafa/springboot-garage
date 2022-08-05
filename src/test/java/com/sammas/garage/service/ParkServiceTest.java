package com.sammas.garage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sammas.garage.dto.Vehicle;
import com.sammas.garage.dto.Vehicles;

@SpringBootTest
public class ParkServiceTest {

    @Autowired
    ParkService parkService;
    
    
    Vehicle vehicle = new Vehicle("Blue", "Jeep", "39-FG-78");

    @DisplayName("Slots By Ticket For Jeep Test")
    @Test
    void test_GetSlotByTicket() { 	
        assertEquals("2-3", parkService.getSlotByTicket("39-FG-78#Blue#2-3"));
    }
    
    
    @DisplayName("Print Ticket Test")
    @Test
    void test_PrintTicket() {  	
        assertEquals("39-FG-78#Blue#2-3", parkService.printTicket(vehicle,"2-3"));
    }
    
    
    @DisplayName("Park Info Test")
    @Test
    void test_GetParkInfo() {   	
        assertEquals("Allocated 2 slot for 39-FG-78 Blue Jeep", parkService.getParkInfo(vehicle,2));
    }
     
    @DisplayName("Slot Size Test")
    @Test
    void get_SlotSize() {   	
        assertEquals(2, Vehicles.getByValue(vehicle.getVehicleType().toUpperCase()));
    }
		
}