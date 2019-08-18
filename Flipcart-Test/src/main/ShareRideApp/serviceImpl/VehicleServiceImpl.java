package main.ShareRideApp.serviceImpl;

import main.ShareRideApp.Constants.Response;
import main.ShareRideApp.Constants.VehicleType;
import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.domain.Vehicle.Vehicle;
import main.ShareRideApp.inventory.InventoryHolder;
import main.ShareRideApp.inventory.InventoryManager;
import main.ShareRideApp.service.VehicleService;
import main.ShareRideApp.service.Factory.InventoryManagerFactory;
import main.ShareRideApp.service.Factory.VehicleServiceFactory;
import main.ShareRideApp.vo.ResponseVo;
import main.ShareRideApp.vo.RideResponseVo;
import main.ShareRideApp.vo.VehicleResponseVo;

public class VehicleServiceImpl implements VehicleService{

	InventoryManager inventoryManager = InventoryManagerFactory.getInventoryManager();
	
	@Override
	public ResponseVo addVehicle(String registrationNo, VehicleType vehicleType, String userName) {
		ResponseVo vo = new RideResponseVo(Response.SUCCESS);
		UserDetails user = InventoryHolder.getUserInventory().get(userName);
		if(user != null) {
			Vehicle vehicleDetails = VehicleServiceFactory.getVehicle(registrationNo, user, vehicleType);
			vo = inventoryManager.addVehicle(vehicleDetails);
		}else {
			vo = new VehicleResponseVo(Response.USER_NOT_REGISTERED);
		}
		System.out.println(vo.getMsg());
		return vo;
	}

	@Override
	public ResponseVo removeVehicle(String registrationNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseVo InactiveVehicle(String registrationNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseVo activeVehicle(String registrationNo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
