package com.sammas.garage.dto;

public enum Vehicles {

	CAR("Car",1),
	TRUCK("Truck",4),
	JEEP("Jeep",2);
	
	
	private String value;
	private int slot;
	
	Vehicles(String vehicleValue, int i) {
		this.value = vehicleValue;
		this.slot = i;
	}

	public String getValue() {
		return value;
	}

	public int getSlotSize() {
		return slot;
	}
	
	public static int getByValue(String type) {
	    for(Vehicles e : values()) {
	        if(e.value.equalsIgnoreCase(type)) return e.slot;
	    }
	    return 0;
	}
	
	
	
}
