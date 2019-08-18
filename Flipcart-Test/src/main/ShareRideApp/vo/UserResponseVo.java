package main.ShareRideApp.vo;

import main.ShareRideApp.Constants.Response;

public class UserResponseVo extends ResponseVo{

	public UserResponseVo(int statusCode, String msg) {
		super(statusCode, msg);
	}
	
	public UserResponseVo(Response response) {
		super(response);
	}
}
