package main.ShareRideApp.serviceImpl;

import java.util.Collections;
import java.util.List;

import main.ShareRideApp.domain.MostVacantRideComparator;
import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.inventory.InventoryManager;
import main.ShareRideApp.service.SelectRideStrategy;
import main.ShareRideApp.service.Factory.InventoryManagerFactory;

public class MostVacentSelectionStrategy extends SelectRideStrategy{

	InventoryManager inventoryManager = InventoryManagerFactory.getInventoryManager();
	
	public List<RideDetails> filterBasedOnSelection(List<RideDetails> offeredRides) {
		Collections.sort(offeredRides, new MostVacantRideComparator());
		return offeredRides;
	}
}
