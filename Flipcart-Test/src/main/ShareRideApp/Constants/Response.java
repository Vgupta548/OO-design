package main.ShareRideApp.Constants;

public enum Response {
	
	SUCCESS(200, "SUCCESS"),
	FAIL(5000, "Fail ! Some Exception Occured"),
	
	USER_ALREADY_EXIST(1000, "User Already Exist"),
	Vehicle_ALREADY_EXIST(1001, "Vehicle Already Exist"),
	RIDE_ALREADY_EXIST(1003, "Ride Already Exist"),
	REQUEST_ALREADY_EXIST(1004, "Request Already Exist"),

	USER_NOT_REGISTERED(2001, "User Not Registered"),
	NO_RIDE_IS_OFFERED_FOR_THIS_PREFRENCE(2002, "NO RIDE IS OFFERED FOR THIS PREFRENCE"),
	RIDE_NOT_EXIST(2002, "Ride Not Exist"),
	Vehicle_NOT_EXIST(2003, "Vehicle Not Exist"),
	
	RIDE_NOT_STARTED_YET(3001, "Ride Not Started yet"),
	
	USER_ADDED_SUCCESSFULLY(10001, "User Added Successfully"),
	VEHICLE_ADDED_SUCCESSFULLY(10002, "Vehicle Added Successfully"),
	RIDE_OFFERED_SUCCESSFULLY(10003, "Ride Offered Successfully"),
	RIDE_SELCTED_SUCCESSFULLY(10004, "Ride Selected Successfully"),
	RIDE_CANCELED_SUCCESSFULLY(10005, "Ride Canceled Successfully"),
	RIDE_STARTED_SUCCESSFULLY(10006, "Ride Started Successfully"),
	RIDE_ENDED_SUCCESSFULLY(10006, "Ride ENDED Successfully");
	
	
	
	
	private int responseCode;
	private String msg;
	
	Response(int code, String msg){
		this.responseCode = code;
		this.msg = msg;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public String getMsg() {
		return msg;
	}
	
}
