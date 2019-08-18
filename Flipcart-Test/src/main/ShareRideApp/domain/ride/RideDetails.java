package main.ShareRideApp.domain.ride;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import main.ShareRideApp.Constants.RideStatus;
import main.ShareRideApp.domain.Address;
import main.ShareRideApp.domain.RideRequest;
import main.ShareRideApp.domain.Vehicle.Vehicle;

public class RideDetails extends Ride{
	
	private Vehicle vehicle;
	private int  availableSeats;
	private List<RideRequest> rideRequests = new ArrayList<RideRequest>();
	private RideStatus status;
	
	
	public RideDetails(Vehicle vehicle, Address source, Address dest, int availableSeats){
		super(source, dest);
		this.vehicle = vehicle;
		this.availableSeats = availableSeats;
		this.status = RideStatus.WAITING;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public List<RideRequest> getRideRequests() {
		return rideRequests;
	}

	public void setRideRequests(List<RideRequest> rideRequests) {
		this.rideRequests = rideRequests;
	}

	public RideStatus getStatus() {
		return status;
	}
	
	public void setStatus(RideStatus status) {
		this.status = status;
	}

	

	public void changeAvailableSeats(boolean isAdd, int noOfSeats) {
		if(isAdd == true) Math.addExact(this.availableSeats, noOfSeats);
		else Math.subtractExact(this.availableSeats, noOfSeats);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(vehicle, availableSeats, status);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof RideDetails)) {
			return false;
		}
		RideDetails other = (RideDetails) obj;
		
		if(!Objects.equals(vehicle, other.getVehicle()) ) {
			return false;
		}
		return true;
	}

}

