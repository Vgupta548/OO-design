package main.ShareRideApp.domain.Vehicle;

import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.service.IVehicleObserver;

public class XUV extends Vehicle implements IVehicleObserver{

	public XUV(String registrationNo, UserDetails user, main.ShareRideApp.Constants.VehicleType VehicleType) {
		super(registrationNo, user, VehicleType);
	}

	@Override
	public void observer() {
		//VehicleResoluter.mapVehicleType.put(main.ShareRideApp.Constants.VehicleType.XUV, this);
	}

}
