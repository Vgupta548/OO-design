package main.ShareRideApp.service;

import java.util.List;
import java.util.Objects;

import main.ShareRideApp.Constants.RideStatus;
import main.ShareRideApp.Constants.UserStatus;
import main.ShareRideApp.Constants.VehicleStatus;
import main.ShareRideApp.inventory.InventoryHolder;

public class SystemManager {

	public static long registeredUser() {
		return InventoryHolder.getUserInventory().values()
				.parallelStream()
				.filter(user ->  user.getStatus() != UserStatus.DELETED)
				.count();
	}
	
	public static long registeredVehicle() {
		return InventoryHolder.getVehicleInventory().values()
				.parallelStream()
				.filter(vehicle ->  vehicle.getStatus() != VehicleStatus.DELETED)
				.count();
	}
	
	public static long ridesWaiting() {
		return InventoryHolder.getRideInventory().values().stream()
				.flatMap(List::stream)
				.filter(ride -> ride.getStatus() == RideStatus.WAITING).count();
	}
	
	public static long rideStarted() {
		return InventoryHolder.getRideInventory().values().stream()
				.flatMap(List::stream)
				.filter(ride -> ride.getStatus() == RideStatus.STARTED).count();
	}
	
	public static long ridesNotEnded() {
		return InventoryHolder.getRideInventory().values().stream().mapToInt(List::size).sum();
	}
	
	public static long rideEnded() {
		return InventoryHolder.getRideHistory().parallelStream()
				.filter(ride ->  Objects.equals(ride.getStatus(), RideStatus.ENDED)).count();
	}
	
	public static long rideEndedWithoutTaken() {
		return InventoryHolder.getRideHistory().parallelStream()
				.filter(ride ->  Objects.equals(ride.getStatus(), RideStatus.ENDED) && ride.getRideRequests().isEmpty()).count();
	}
	
	public static long rideTakenAndEnded() {
		return InventoryHolder.getRideHistory().parallelStream()
				.filter(ride ->  Objects.equals(ride.getStatus(), RideStatus.ENDED) && !ride.getRideRequests().isEmpty()).count();
	}
	
	/*public static long Ridetaken() {
		return InventoryHolder.getRideHistory().values()
		.parallelStream()
		.filter(ride ->  ride.getStatus() == RideStatus.ENDED && ride.isTaken())
		.count();
	}*/
	
	
	
	
	public static void RideStates() {
		
	}
}
