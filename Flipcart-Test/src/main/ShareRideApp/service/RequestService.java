package main.ShareRideApp.service;

import main.ShareRideApp.domain.RideRequest;
import main.ShareRideApp.vo.ResponseVo;

public interface RequestService {

	ResponseVo createRequest(RideRequest rideRequest);
	
}
