package main.ShareRideApp.serviceImpl;

import main.ShareRideApp.Constants.Response;
import main.ShareRideApp.domain.User.UserDetails;
import main.ShareRideApp.inventory.InventoryManager;
import main.ShareRideApp.service.UserService;
import main.ShareRideApp.service.Factory.InventoryManagerFactory;
import main.ShareRideApp.vo.ResponseVo;
import main.ShareRideApp.vo.RideResponseVo;

public class UserServiceImpl implements UserService{

	InventoryManager inventoryManager = InventoryManagerFactory.getInventoryManager();
	
	public ResponseVo addUser(String name, char gender, int age) {
		ResponseVo vo = new RideResponseVo(Response.SUCCESS);
		UserDetails userDetail = new UserDetails(name, gender,  age);
		vo = inventoryManager.addUser(userDetail);
		System.out.println(vo.getMsg());
		return vo;
	}

	@Override
	public ResponseVo removeUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseVo BlockUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
