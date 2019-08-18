package main.ShareRideApp.service.Factory;

import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.domain.Vehicle.Activa;
import main.ShareRideApp.domain.Vehicle.Baleno;
import main.ShareRideApp.domain.Vehicle.Polo;
import main.ShareRideApp.domain.Vehicle.Swift;
import main.ShareRideApp.domain.Vehicle.Vehicle;
import main.ShareRideApp.domain.Vehicle.XUV;
import main.ShareRideApp.service.VehicleService;
import main.ShareRideApp.serviceImpl.VehicleServiceImpl;

public class VehicleServiceFactory {
	
	private static VehicleService vehicleService = new VehicleServiceImpl();
	
	public static VehicleService getVehicleService(){
		return vehicleService;
	}
	
	public static Vehicle getVehicle(String registrationNo, UserDetails user, main.ShareRideApp.Constants.VehicleType vehicleType){
		
		switch(vehicleType) {
		case  POLO :
		 return new Polo(registrationNo, user, vehicleType);
		case  BALENO :
		 return new Baleno(registrationNo, user, vehicleType);
		case  XUV :
			 return new XUV(registrationNo, user, vehicleType);
		case  SWIFT :
			 return new Swift(registrationNo, user, vehicleType);
		case  ACTIVA :
			 return new Activa(registrationNo, user, vehicleType);
		default : 
		 return new Baleno(registrationNo, user, vehicleType);
		}
	}

}
