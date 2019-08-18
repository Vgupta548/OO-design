package main.ShareRideApp.service;

import main.ShareRideApp.vo.ResponseVo;

public interface UserService {

	ResponseVo addUser(String name, char gender, int age);
	
	ResponseVo removeUser(String name);
	
	ResponseVo BlockUser(String name);
	
}
