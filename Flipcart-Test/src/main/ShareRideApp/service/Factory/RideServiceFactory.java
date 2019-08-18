package main.ShareRideApp.service.Factory;

import main.ShareRideApp.service.RideService;
import main.ShareRideApp.serviceImpl.RideServiceImpl;

public class RideServiceFactory {

private static RideService rideService = new RideServiceImpl();
	
	public static RideService getRideService(){
		return rideService;
	}
}
