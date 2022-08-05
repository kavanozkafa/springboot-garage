package com.sammas.garage.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.sammas.garage.validation.Enum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(value ="Vehicle Model", description ="Object Model for Vehicle")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Vehicle {

	@NotEmpty(message = "Please enter vehicle color")
	@Enum(enumClass=Colors.class,message="Not a valid color type", ignoreCase=true)
	@ApiModelProperty(example = "RED",value="Vehicle color", required = true) 
	private String color;


	@NotEmpty(message = "Please enter vehicle type")
	@Enum(enumClass=Vehicles.class,message="Not a valid vehicle type", ignoreCase=true)
	@ApiModelProperty(example = "Jeep",value="Vehicle type", required = true)
	private String vehicleType;
	
	
	@Pattern(regexp="^([0-9]{2})(\\-?\\s?)([A-Z]{1,3})(\\-?\\s?)([0-9]{2,4})$")
	@NotEmpty(message = "Please enter vehicle's license plate") 
	@ApiModelProperty(example = "34-SC-2022",value="vehicle's license plate", required = true)
	private String licensePlate;

		
	public Vehicle(
			@Enum(enumClass=Colors.class,message="Not a valid color type", ignoreCase=true)
			@NotEmpty(message = "Please enter vehicle color") String color,
			@Enum(enumClass=Vehicles.class,message="Not a valid vehicle type", ignoreCase=true)
			@NotEmpty(message = "Please enter vehicle type") String vehicleType,
			@Pattern(regexp = "^([0-9]{2})(\\-?\\s?)([A-Z]{1,3})(\\-?\\s?)([0-9]{2,4})$") 
			@NotNull(message = "Please enter vehicle's license plate") String licensePlate) {
		super();
		this.color = color;
		this.vehicleType = vehicleType;
		this.licensePlate = licensePlate;
	}


	public Vehicle() {
		super();
	}

 

}