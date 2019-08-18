package main.ShareRideApp.vo;

import main.ShareRideApp.Constants.Response;

public class RideResponseVo  extends ResponseVo{

	public RideResponseVo(int statusCode, String msg) {
		super(statusCode, msg);
	}
	
	public RideResponseVo(Response response) {
		super(response);
	}
}
