package com.sammas.garage.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.sammas.garage.dto.Garage;
import com.sammas.garage.dto.Vehicle;
import com.sammas.garage.dto.Vehicles;
import com.sammas.garage.exception.LicensePlateMultipleException;
import com.sammas.garage.exception.VehicleNotFoundException;

@Service
public class ParkService {

	int garageCapacity = 10;
	List<Garage> garage = Collections.synchronizedList(new ArrayList<Garage>());
	private Logger logger = LoggerFactory.getLogger(ParkService.class);

	@EventListener(ApplicationReadyEvent.class)
	private void initGarage() {

		for (int i = 0; i < garageCapacity; i++) {
			garage.add(null);
		}

		logger.info("Garage initialized.");

	}

	public HashMap<String, Object> getStatus() {
		ArrayList<String> carList = new ArrayList<String>();
		HashMap<String, Object> garageStatus = new HashMap<String, Object>();

		try {
			for (Garage g : garage) {
				if (g != null && !carList.contains(g.toString()))
					carList.add(g.toString());

			}
			garageStatus.put("garageStatus", carList);

		} catch (Exception e) {
			garageStatus.put("garageStatus", "Something went wrong !");
			logger.error(e.getMessage());
		}

		logger.info(garageStatus.toString());
		return garageStatus;

	}

	public synchronized HashMap<String, String> park(Vehicle vehicle) {
		HashMap<String, String> ticket = new HashMap<String, String>();

		try {
			int slotSize = getSlotSize(vehicle);

			if (checkVehicleByLicensePlate(vehicle.getLicensePlate()))
				throw new LicensePlateMultipleException(vehicle.getLicensePlate());

			String slots = getAvailableSlots(slotSize);

			if (!slots.equals("")) {

				Garage park = new Garage(
						new Vehicle(vehicle.getColor(), vehicle.getVehicleType(), vehicle.getLicensePlate()), slots,
						true);

				String[] vehicleSlots = slots.split("-");
				int slotList = vehicleSlots.length;
				for (int i = 0; i < slotList; i++)
					garage.set(Integer.valueOf(vehicleSlots[i]), park);

				ticket.put("message", getParkInfo(vehicle, slotSize));
				ticket.put("ticketId", printTicket(vehicle, slots));

			} else {
				ticket.put("message", "Garage is full . There is no available parking slot");
				ticket.put("ticketId", "Not Available !");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info(ticket.toString());
		return ticket;

	}

	public synchronized String leave(String ticketId) {

		if (ticketId == null)
			throw new IllegalArgumentException(ticketId);

		String response = "Your vehicle is ready !";

		if (findVehicleByTicketId(ticketId)) {
			String[] slots = getSlotByTicket(ticketId).split("-");
			for (int i = 0; i < slots.length; i++) {
				garage.set(Integer.valueOf(slots[i]), null);
			}
		} else
			throw new VehicleNotFoundException(ticketId);

		return response;

	}

	public synchronized boolean findVehicleByTicketId(String ticketId) {
		String[] carInfo = ticketId.split("#");
		return checkVehicleByLicensePlate(carInfo[0]);
	}

	public synchronized boolean checkVehicleByLicensePlate(String licensePlate) {
		boolean inGarage = false;

		for (Garage g : garage)
			if (g != null && g.getVehicle().getLicensePlate().equalsIgnoreCase(licensePlate))
				inGarage = true;

		return inGarage;
	}

	public synchronized String getParkInfo(Vehicle vehicle, int slotSize) {
		return "Allocated " + slotSize + " slot for " + vehicle.getLicensePlate() + " " + vehicle.getColor() + " "
				+ vehicle.getVehicleType();
	}

	public synchronized String printTicket(Vehicle vehicle, String slots) {
		return vehicle.getLicensePlate() + "#" + vehicle.getColor() + "#" + slots;
	}

	public synchronized String getSlotByTicket(String ticketId) {
		return ticketId.split("#")[2];

	}

	public synchronized int getSlotSize(Vehicle vehicle) {
		return Vehicles.getByValue(vehicle.getVehicleType().toUpperCase());

	}

	public synchronized String getAvailableSlots(int slotSize) {

		int garageSize = garage.size();
		String slots = "";

		int minSlotsForVehicle = slotSize + 1;
		int firstEmptySlot = garage.indexOf(null);

		if (firstEmptySlot != 0)
			minSlotsForVehicle = 1 + slotSize + 1;

		int firstPlace = 0;
		int lastPlace = 9;
		int count = 0;
		boolean found = false;
		for (int i = firstPlace; i < garageSize; i++) {
			if (garage.get(i) == null) {
				count++;
				if (count == minSlotsForVehicle || (count == slotSize + 1 && i == 9)) {
					lastPlace = i;
					firstPlace = i - count + 1;
					found = true;
					break;
				}
			} else {
				count = 0;
			}
		}

		if (!found)
			return slots;

		if (firstPlace != 0)
			firstPlace = firstPlace + 1;

		if (lastPlace == 9)
			lastPlace = lastPlace + 1;

		for (int j = firstPlace; j < lastPlace; j++)
			slots = slots + "-" + String.valueOf(j);

		return slots.replaceFirst("-", "");

	}

}
