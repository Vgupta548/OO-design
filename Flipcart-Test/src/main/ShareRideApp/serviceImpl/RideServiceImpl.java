package main.ShareRideApp.serviceImpl;

import main.ShareRideApp.Constants.ApplicationConstants;
import main.ShareRideApp.Constants.RequestStatus;
import main.ShareRideApp.Constants.Response;
import main.ShareRideApp.Constants.RideStatus;
import main.ShareRideApp.domain.Address;
import main.ShareRideApp.domain.RideRequest;
import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.domain.Vehicle.Vehicle;
import main.ShareRideApp.domain.ride.Ride;
import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.inventory.InventoryHolder;
import main.ShareRideApp.inventory.InventoryManager;
import main.ShareRideApp.service.RideSelectionStrategy;
import main.ShareRideApp.service.RideService;
import main.ShareRideApp.service.Factory.InventoryManagerFactory;
import main.ShareRideApp.vo.ResponseVo;
import main.ShareRideApp.vo.RideResponseVo;

public class RideServiceImpl implements RideService{

	InventoryManager inventoryManager = InventoryManagerFactory.getInventoryManager();
	
	@Override
	public ResponseVo OfferRide(String vehicleRegistractionNo, Address source, Address dest, int availableSeats) {
		Vehicle vehicle = inventoryManager.getVehicle(vehicleRegistractionNo);
		RideDetails rideDetails = new RideDetails(vehicle, source, dest, availableSeats);
		ResponseVo vo = inventoryManager.addRide(rideDetails);
		System.out.println(vo.getMsg());
		return vo;
	}

	@Override
	public ResponseVo endRide(RideDetails rideDetails) {
		ResponseVo vo = new RideResponseVo(Response.SUCCESS);
		if(rideDetails !=null) {
			java.util.List<RideDetails> allRides =	 InventoryHolder.getRideInventory().get(getRideInventoryKey(rideDetails));
			RideDetails ride = allRides.parallelStream().filter(r -> r.equals(rideDetails)).findAny().orElse(null);
			if(ride != null) {
				if(ride.getStatus() == RideStatus.STARTED) {
					ride.setStatus(RideStatus.ENDED);
					allRides.remove(ride);
					inventoryManager.addRideToHistory(ride);
					vo = new RideResponseVo(Response.RIDE_ENDED_SUCCESSFULLY);
				}else {
					vo = new RideResponseVo(Response.RIDE_NOT_STARTED_YET);
				}
			}
		}else {
			vo = new RideResponseVo(Response.RIDE_NOT_EXIST); 
		}
		System.out.println(vo.getMsg());
		return vo;
	}

	public ResponseVo startRide(RideDetails rideDetails) {
		ResponseVo vo = new RideResponseVo(Response.SUCCESS);
		if(rideDetails != null) {
			rideDetails.setStatus(RideStatus.STARTED);
			vo = new RideResponseVo(Response.RIDE_STARTED_SUCCESSFULLY);
		}else {
			vo = new RideResponseVo(Response.RIDE_NOT_EXIST); 
		}
		System.out.println(vo.getMsg());
		return vo;
	}
	
	@Override
	public ResponseVo cancelRide(Ride ride) {
		
		return null;
	}

	@Override
	public RideDetails ServeRide(String userName, Address source, Address dest, int seatRequest, RideSelectionStrategy rideSelectionStrategy) {
		UserDetails user = inventoryManager.getUser(userName);
		RideRequest rideRequest = new RideRequest(user, source, dest, seatRequest);
		if(rideSelectionStrategy == null) rideSelectionStrategy = ApplicationConstants.defaultRideSelectionStrategy;
		RideDetails ridesDetails =  rideSelectionStrategy.SelectRide(rideRequest);
		
		if(ridesDetails != null) {
			rideRequest.setStatus(RequestStatus.SERVED);
			ridesDetails.changeAvailableSeats(false,rideRequest.getSeatRequest());
			ridesDetails.getRideRequests().add(rideRequest);
			System.out.println(Response.RIDE_SELCTED_SUCCESSFULLY.getMsg());
		}else {
			System.out.println("Ride Not Available");
		}
		return ridesDetails;
	}
	
	public String getRideInventoryKey(Ride ride) {
		String key = InventoryHolder.getRideInventoryKey(ride.getSourceAddress(), ride.getDestAddress());
		return key;
	}
}
