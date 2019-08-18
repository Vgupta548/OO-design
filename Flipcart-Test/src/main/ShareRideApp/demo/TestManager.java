package main.ShareRideApp.demo;

import java.util.ArrayList;
import java.util.List;

import main.ShareRideApp.Constants.VehicleType;
import main.ShareRideApp.domain.Address;
import main.ShareRideApp.domain.ride.RideDetails;
import main.ShareRideApp.service.RideService;
import main.ShareRideApp.service.SystemManager;
import main.ShareRideApp.service.UserService;
import main.ShareRideApp.service.VehicleService;
import main.ShareRideApp.service.Factory.RideServiceFactory;
import main.ShareRideApp.service.Factory.UserServiceFactory;
import main.ShareRideApp.service.Factory.VehicleServiceFactory;
import main.ShareRideApp.serviceImpl.MostVacentSelectionStrategy;
import main.ShareRideApp.serviceImpl.PreferedVehicleSelectionStrategy;
import main.ShareRideApp.vo.ResponseVo;

public class TestManager {

	private static UserService userService = UserServiceFactory.getUserService();
	private static VehicleService vehicleService = VehicleServiceFactory.getVehicleService();
	private static RideService rideService = RideServiceFactory.getRideService();
	
	
	
	
	public static void initialize() {
		addUsers();
		report();
		
		addVehicle();
		report();
		
		offerRide();
		report();
		
		List<RideDetails> rides = selectRide();
		report();
		
		endRide(rides);
		report();
	}
	
	public static void  report() {
		System.out.println("---------------------------------");
		System.out.println("Total Registered User :"+SystemManager.registeredUser());
		System.out.println("Total Registered Vehicle :"+SystemManager.registeredVehicle());
		System.out.println("Total current Offered Ride "+SystemManager.ridesNotEnded());
		System.out.println("Total current Offered Waiting Ride "+SystemManager.ridesWaiting());
		System.out.println("Total current Offered Started Ride "+SystemManager.rideStarted());
		System.out.println("Total Ride ended:"+SystemManager.rideEnded());
		System.out.println("Total Ride ended without taken:"+SystemManager.rideEndedWithoutTaken());
		
		System.out.println("---------------------------------");
	}
	
	private static void addUsers() {
		userService.addUser("Rohan", 'M', 36);
		userService.addUser("Rohan", 'M', 36);
		
		userService.addUser("Shashank", 'M',29);
		userService.addUser("Nandini", 'F', 29);
		userService.addUser("Shipra", 'F', 27);
		userService.addUser("Gaurav", 'M', 29);
		userService.addUser("Rahul", 'M', 35);
	}
	
	private static void addVehicle() {
		vehicleService.addVehicle("KA-01-12345", VehicleType.SWIFT, "Rohan");
		vehicleService.addVehicle("KA-01-12345", VehicleType.SWIFT, "Rohan1");
		vehicleService.addVehicle("KA-01-12345", VehicleType.SWIFT, "Rohan");
		vehicleService.addVehicle("TS-05-62395", VehicleType.BALENO, "Shashank");
		vehicleService.addVehicle("KA-05-41491", VehicleType.POLO, "Shipra");
		vehicleService.addVehicle("KA-12-12332", VehicleType.ACTIVA, "Shipra");
		vehicleService.addVehicle("KA-05-1234",  VehicleType.XUV, "Rahul");
		
	}
	
	private static void offerRide() {
		rideService.OfferRide("KA-01-12345", new Address("Hyderabad"), new Address("Bangalore"), 1);
		rideService.OfferRide("KA-12-12332", new Address("Bangalore"), new Address("Maysore"),   1);
		rideService.OfferRide("KA-05-41491", new Address("Bangalore"), new Address("Maysore"),   2);
		rideService.OfferRide("TS-05-62395", new Address("Hyderabad"), new Address("Bangalore"), 3);
		rideService.OfferRide("KA-05-1234",  new Address("Hyderabad"), new Address("Bangalore"), 5);
		rideService.OfferRide("KA-01-12345", new Address("Bangalore"), new Address("Pune"),      1);
	}
	
	private static List<RideDetails> selectRide() {
		List<RideDetails> rides = new ArrayList<RideDetails>();
		RideDetails ride1 = rideService.ServeRide("Nandini",  	new Address("Bangalore"), 	new Address("Maysore"),   	1, new MostVacentSelectionStrategy());
		rideService.startRide(ride1);
		RideDetails ride2 = rideService.ServeRide("Gaurav", 	new Address("Bangalore"), 	new Address("Maysore"),   	1, new PreferedVehicleSelectionStrategy("Activa"));
		RideDetails ride3 = rideService.ServeRide("Shashank",  	new Address("Mumbai"), 		new Address("Bangalore"),   1, new MostVacentSelectionStrategy());
		rideService.startRide(ride3);
		RideDetails ride4 = rideService.ServeRide("Rohan",  	new Address("Hyderabad"), 	new Address("Bangalore"),   1, new PreferedVehicleSelectionStrategy("Baleno"));
		RideDetails ride5 = rideService.ServeRide("Shashank",  	new Address("Hyderabad"), 	new Address("Bangalore"),   1, new PreferedVehicleSelectionStrategy("Polo"));
		rideService.startRide(ride5);
		
		rides.add(ride1);
		rides.add(ride2);
		rides.add(ride3);
		rides.add(ride4);
		rides.add(ride5);
		return rides;
	}
	
	private static void endRide(List<RideDetails> rides) {
		for(int i=0; i<rides.size()/2 ;i++) {
			rideService.endRide(rides.get(i));
		}
	}
	
}
