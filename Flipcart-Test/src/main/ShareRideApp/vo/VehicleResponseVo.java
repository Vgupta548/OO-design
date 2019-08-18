package main.ShareRideApp.vo;

import main.ShareRideApp.Constants.Response;

public class VehicleResponseVo extends ResponseVo{

	public VehicleResponseVo(int statusCode, String msg) {
		super(statusCode, msg);
	}
	
	public VehicleResponseVo(Response response) {
		super(response);
	}
}
