package main.ShareRideApp.service;

import main.ShareRideApp.Constants.VehicleType;
import main.ShareRideApp.vo.ResponseVo;

public interface VehicleService {

	ResponseVo addVehicle(String registrationNo, VehicleType vehicleType, String userName);
	
	ResponseVo removeVehicle(String registrationNo);
	
	ResponseVo InactiveVehicle(String registrationNo);
	
	ResponseVo activeVehicle(String registrationNo);
	
}
