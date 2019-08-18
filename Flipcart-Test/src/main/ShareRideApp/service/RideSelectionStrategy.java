package main.ShareRideApp.service;

import main.ShareRideApp.domain.RideRequest;
import main.ShareRideApp.domain.ride.RideDetails;

public interface RideSelectionStrategy {
	
	RideDetails SelectRide(RideRequest rideRequest);

}
