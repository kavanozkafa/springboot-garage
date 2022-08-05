package com.sammas.garage.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sammas.garage.exception.VehicleNotFoundException;
import com.sammas.garage.service.ParkService;

@SpringBootTest
public class ExceptionTest {

    private ParkService demo = new ParkService();

    @DisplayName("Illegal Argument Exception Test")
    @Test
    public void givenNull_whenInvokedWithMethod_thenIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> demo.leave(null));
    }
    
    @DisplayName("Ticket Not Found Exception Test")
    @Test
    public void givenWrongTicket_whenInvokedWithMethod_thenIllegalArgumentException() {
        assertThrows(VehicleNotFoundException.class, () -> demo.leave("390-FG-78#Blue#2-3"));
    }

}