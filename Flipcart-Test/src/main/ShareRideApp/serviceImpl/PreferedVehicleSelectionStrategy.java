package main.ShareRideApp.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.inventory.InventoryManager;
import main.ShareRideApp.service.SelectRideStrategy;
import main.ShareRideApp.service.Factory.InventoryManagerFactory;

public class PreferedVehicleSelectionStrategy extends SelectRideStrategy{

	private final String vehicleType;
	
	InventoryManager inventoryManager = InventoryManagerFactory.getInventoryManager();
	
	public PreferedVehicleSelectionStrategy(String vehicleName) {
		this.vehicleType = vehicleName;
	}
	
	public List<RideDetails> filterBasedOnSelection(List<RideDetails> offeredRides) {
		return offeredRides.parallelStream().filter(r -> r.getVehicle().getVehicleType().equals(vehicleType)).collect(Collectors.toList());
	}
	
	

}
