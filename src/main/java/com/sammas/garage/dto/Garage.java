package com.sammas.garage.dto;

public class Garage {

	 
	private Vehicle vehicle;

	private String slot;
	
	private boolean isTaken ;
	
 

	public Garage() {
		super();
	}

	public Garage(Vehicle vehicle, String slot, boolean isTaken) {
		super();
		this.vehicle = vehicle;
		this.slot = slot;
		this.isTaken = isTaken;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@Override
	public String toString() {
		return vehicle.getLicensePlate()+" "+vehicle.getColor()+" "+ vehicle.getVehicleType() + " [" + slot + "]";
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	
	
}
