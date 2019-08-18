package main.ShareRideApp.service.Factory;

import main.ShareRideApp.service.UserService;
import main.ShareRideApp.serviceImpl.UserServiceImpl;

public class UserServiceFactory {
	
	private static UserService userService = new UserServiceImpl();
	
	public static UserService getUserService(){
		return userService;
	}

}
