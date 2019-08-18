package main.ShareRideApp.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.ShareRideApp.domain.Address;
import main.ShareRideApp.domain.RideRequest;
import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.domain.Vehicle.Vehicle;
import main.ShareRideApp.domain.ride.RideDetails;

public class InventoryHolder {

	private static Map<String, UserDetails> userInventory = new HashMap<String, UserDetails>();
	private static Map<String, Vehicle> vehicleInventory = new HashMap<String, Vehicle>();
	
	private static Map<String, ArrayList<RideDetails>> rideInventory = new HashMap<String, ArrayList<RideDetails>>();
	private static Map<RideRequest, RideRequest> rideRequestInventory = new HashMap<RideRequest, RideRequest>();
	
	private static java.util.List<RideDetails> rideHistory = new ArrayList<RideDetails>();
	private static Map<RideRequest, RideRequest> requestHistory = new HashMap<RideRequest, RideRequest>();
	

	
	public static Map<String, UserDetails> getUserInventory() {
		return userInventory;
	}
	public static Map<String, Vehicle> getVehicleInventory() {
		return vehicleInventory;
	}
	public static Map<String, ArrayList<RideDetails>> getRideInventory() {
		return rideInventory;
	}
	public static Map<RideRequest, RideRequest> getRideRequestInventory() {
		return rideRequestInventory;
	}
	public static java.util.List<RideDetails> getRideHistory() {
		return rideHistory;
	}
	public static Map<RideRequest, RideRequest> getRequestHistory() {
		return requestHistory;
	}
	
	public static String getRideInventoryKey(Address source, Address dest) {
		return source.toString()+"|"+source.toString();
	}
	
	
	
}
