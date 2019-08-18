package main.ShareRideApp.domain.Vehicle;

import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.service.IVehicleObserver;

public class Polo  extends Vehicle implements IVehicleObserver{

	public Polo(String registrationNo, UserDetails user, main.ShareRideApp.Constants.VehicleType VehicleType) {
		super(registrationNo, user, VehicleType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void observer() {
	//	VehicleResoluter.mapVehicleType.put(main.ShareRideApp.Constants.VehicleType.POLO, this);
	//	VehicleResoluter.mapVehicleTypeObj.put(main.ShareRideApp.Constants.VehicleType.POLO, this);
		//VehicleResoluter.mapVehicleTypeClazz.put(main.ShareRideApp.Constants.VehicleType.POLO, Polo.class);
		
		
	}

}
