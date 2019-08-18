package main.ShareRideApp.vo;

import main.ShareRideApp.Constants.Response;

public abstract class ResponseVo {

	protected int statusCode;
	protected String msg;
	
	
	public ResponseVo(int statusCode, String msg) {
		this.statusCode = statusCode;
		this.msg = msg;
	}
	
	public ResponseVo(Response response) {
		this.statusCode = response.getResponseCode();
		this.msg = response.getMsg();
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
