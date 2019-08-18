package main.ShareRideApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.ShareRideApp.domain.RideRequest;
import main.ShareRideApp.domain.ride.Ride;
import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.inventory.InventoryManager;
import main.ShareRideApp.service.Factory.InventoryManagerFactory;

public abstract class SelectRideStrategy implements RideSelectionStrategy{

	InventoryManager inventoryManager = InventoryManagerFactory.getInventoryManager();
	
	public RideDetails SelectRide(RideRequest rideRequest) {
		RideDetails ride  = null;
		try {
			List<RideDetails> offeredRides = new ArrayList<RideDetails>();
			offeredRides = offerdRideForThisRoute(rideRequest);
			if(offeredRides != null && !offeredRides.isEmpty()) {
				offeredRides = filterBasedOnSelection(offeredRides);
				if(offeredRides != null && !offeredRides.isEmpty()) {
					offeredRides = filterForRequestedSeats(offeredRides, rideRequest.getSeatRequest());
					if(offeredRides != null && !offeredRides.isEmpty()) {
						ride = offeredRides.get(0);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ride;
	}
	
	private List<RideDetails> offerdRideForThisRoute(Ride ride) throws Exception {
		return inventoryManager.fetchOfferedRideForTheRoute(ride);
	}
	
	private List<RideDetails> filterForRequestedSeats(List<RideDetails> offeredRides, int requestSeats) throws Exception {
		return offeredRides.parallelStream().filter(r -> r.getAvailableSeats() >= requestSeats).collect(Collectors.toList());
	}
	
	
	abstract public List<RideDetails> filterBasedOnSelection(List<RideDetails> offeredRides);
	
}
