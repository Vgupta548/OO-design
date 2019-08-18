package main.ShareRideApp.domain.Vehicle;

import java.util.Vector;

import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.service.IVehicleObserver;

public class Baleno extends Vehicle implements IVehicleObserver{

	public Baleno(String registrationNo, UserDetails user, main.ShareRideApp.Constants.VehicleType VehicleType) {
		super(registrationNo, user, VehicleType);
	}

	@Override
	public void observer() {
		//VehicleResoluter.mapVehicleType.put(main.ShareRideApp.Constants.VehicleType.BALENO, this);
		
	}

}
