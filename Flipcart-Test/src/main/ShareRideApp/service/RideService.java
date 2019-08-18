package main.ShareRideApp.service;

import main.ShareRideApp.domain.Address;
import main.ShareRideApp.domain.ride.Ride;
import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.vo.ResponseVo;

public interface RideService {

	ResponseVo OfferRide(String vehicleRegistractionNo, Address source, Address dest, int availableSeats);
	
	RideDetails ServeRide(String userName, Address source, Address dest, int seatRequest, RideSelectionStrategy rideSelectionStrategy);
	
	ResponseVo startRide(RideDetails rideDetails) ;
	
	ResponseVo cancelRide(Ride ride);
	
	ResponseVo endRide(RideDetails rideDetails);
	
	

	
}
