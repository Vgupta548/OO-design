package main.ShareRideApp.domain;

import main.ShareRideApp.Constants.RequestStatus;
import main.ShareRideApp.domain.User.User;
import main.ShareRideApp.domain.ride.Ride;

public class RideRequest extends Ride{
	
	private User user;
	int seatRequest;
	RequestStatus status;
	
	public RideRequest(User user, Address source, Address dest, int seatRequest) { 
		super(source, dest);
		this.user = user;
		this.seatRequest = seatRequest;
		this.status = RequestStatus.OPEN;
		
	}
	
	public User getUser() {
		return user;
	}

	public int getSeatRequest() {
		return seatRequest;
	}

	public RequestStatus getStatus() {
		return status;
	}
	
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	
}
