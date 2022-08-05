package com.sammas.garage.validation;

 
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.sammas.garage.dto.Vehicle;

public class ValidationTest {

    private static Validator validator;

    Vehicle vehicle = new Vehicle("Blue", "Jeep", "39-FG-78");
    
    
    @BeforeAll
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @DisplayName("Vehicle Validation Test")
    @Test
    public void ifVehicleMatchAllBeanValidations_vehicleValidationPass() {
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(violations.isEmpty(), true);
    }
    
    @DisplayName("Vehicle toString Test")
    @Test
    public void whenToString_thenCorrect() {
    	Vehicle vehicle = new Vehicle("Blue", "Jeep", "39-FG-78");
        assertThat(vehicle.toString()).isEqualTo("Vehicle(color=Blue, vehicleType=Jeep, licensePlate=39-FG-78)");
    }
        
    @DisplayName("Color Empty Value Validation Test")
    @Test
    public void ifColorIsEmpty_vehicleValidationFails() {
    	 Vehicle vehicle = new Vehicle("", "Jeep", "39-FG-78");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(violations.isEmpty(), false);
    }

    @DisplayName("Vehicle Type Empty Value Validation Test")
    @Test
    public void ifVehicleTypeIsEmpty_vehicleValidationFails() {
    	 Vehicle vehicle = new Vehicle("Blue", "", "39-FG-78");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(violations.isEmpty(), false);
    }
    
    @DisplayName("License Plate Empty Value Validation Test")
    @Test
    public void ifLicensePlateIsEmpty_vehicleValidationFails() {
    	 Vehicle vehicle = new Vehicle("Blue", "Jeep", "");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(violations.isEmpty(), false);
    }
    
    @DisplayName("License Plate Pattern Validation Test")
    @Test
    public void ifLicensePlateIsNotMatchPattern_vehicleValidationFails() {
    	 Vehicle vehicle = new Vehicle("Blue", "Jeep", "399-FG-78");
        Set<ConstraintViolation<Vehicle>> violations = validator.validate(vehicle);
        assertEquals(violations.isEmpty(), false);
    }
    
}
