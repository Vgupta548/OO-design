package main.ShareRideApp.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import main.ShareRideApp.Constants.Response;
import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.domain.Vehicle.Vehicle;
import main.ShareRideApp.domain.ride.Ride;
import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.vo.ResponseVo;
import main.ShareRideApp.vo.RideResponseVo;
import main.ShareRideApp.vo.UserResponseVo;
import main.ShareRideApp.vo.VehicleResponseVo;

public class InventoryManager {

	public  ResponseVo addUser(UserDetails userDetail){
		ResponseVo vo ;
		try {
			if(isUserPresent(userDetail.getName())) {
				vo = new UserResponseVo(Response.USER_ALREADY_EXIST);
			}else {
				InventoryHolder.getUserInventory().put(userDetail.getName(), userDetail);
				vo = new UserResponseVo(Response.USER_ADDED_SUCCESSFULLY);
			}
		}catch (Exception e) {
			System.out.println("Exception occured while adding user to inventory");
			vo = new UserResponseVo(Response.FAIL);
		}
		return vo;
	}
	
	public UserDetails getUser(String userName) {
		return InventoryHolder.getUserInventory().get(userName);
	}
	
	public  ResponseVo addVehicle(Vehicle vehileDetail){
		ResponseVo vo ;
		try {
			
			if(isVehiclePresent(vehileDetail.getRegistrationNo())) {
				vo = new VehicleResponseVo(Response.Vehicle_ALREADY_EXIST);
			}else {
				InventoryHolder.getVehicleInventory().put(vehileDetail.getRegistrationNo(), vehileDetail);
				vo = new VehicleResponseVo(Response.VEHICLE_ADDED_SUCCESSFULLY);
			}
		}catch (Exception e) {
			System.out.println("Exception occured while adding veicle to inventory");
			vo = new VehicleResponseVo(Response.FAIL);
		}
		return vo;
	}
	
	public Vehicle getVehicle(String registrationNo) {
		return InventoryHolder.getVehicleInventory().get(registrationNo);
	}
	
	public  ResponseVo addRide(RideDetails ride){
		ResponseVo vo ;
		try {
			String key = InventoryHolder.getRideInventoryKey(ride.getSourceAddress(), ride.getDestAddress());
			if(isVehicleAlreadyOfferedARide(ride.getVehicle())) {
				vo = new RideResponseVo(Response.RIDE_ALREADY_EXIST);
			}else {
				InventoryHolder.getRideInventory().computeIfAbsent(key, k -> new ArrayList<RideDetails>()).add(ride);
				vo = new VehicleResponseVo(Response.RIDE_OFFERED_SUCCESSFULLY);
			}
		}catch (Exception e) {
			System.out.println("Exception occured while adding ride to inventory : "+e);
			vo = new VehicleResponseVo(Response.FAIL);
		}
		return vo;
	}
	
	public  ResponseVo addRideToHistory(RideDetails ride){
		ResponseVo vo ;
		try {
			InventoryHolder.getRideHistory().add(ride);
			vo = new VehicleResponseVo(Response.SUCCESS);;
		}catch (Exception e) {
			System.out.println("Exception occured while adding ride to history inventory");
			vo = new VehicleResponseVo(Response.FAIL);
		}
		return vo;
	}
	
	public List<RideDetails> fetchOfferedRideForTheRoute(Ride ride) throws Exception{
		List<RideDetails> rides = new ArrayList<RideDetails>() ;
		try {
			String key = getRideInventoryKey(ride);
			rides = InventoryHolder.getRideInventory().getOrDefault(key, new ArrayList<RideDetails>());
		}catch (Exception e) {
			System.out.println("Exception occured while fetching ride from inventory");
			throw new Exception("Exception occured while fetching ride from inventory");
		}
		return rides;
	}
	
	
	public  boolean isUserPresent(String userName) {
		return InventoryHolder.getUserInventory().containsKey(userName);
	}
	
	public  boolean isVehiclePresent(String registrationNo) {
		return InventoryHolder.getVehicleInventory().containsKey(registrationNo);
	}
	
	public boolean isVehicleAlreadyOfferedARide(Vehicle vehicleDetails) {
		List<RideDetails> allRides =	 InventoryHolder.getRideInventory().values().parallelStream().flatMap(List::stream).collect(Collectors.toList());
		boolean rideAlreadyOffered = allRides.parallelStream().anyMatch(ride -> Objects.equals(ride.getVehicle(), vehicleDetails) );
		return rideAlreadyOffered;
	}
	
	public  boolean isRideAlreadyOffered(RideDetails rideDetails) {
		List<RideDetails> allRides =	 InventoryHolder.getRideInventory().getOrDefault(getRideInventoryKey(rideDetails), new ArrayList<RideDetails>());
		boolean rideAlreadyOffered = allRides.parallelStream().anyMatch(ride -> ride.equals(rideDetails) );
		return rideAlreadyOffered;
	}
	
	public String getRideInventoryKey(Ride ride) {
		String key = InventoryHolder.getRideInventoryKey(ride.getSourceAddress(), ride.getDestAddress());
		return key;
	}
}
