package main.ShareRideApp.domain.Vehicle;

import java.util.Objects;

import main.ShareRideApp.Constants.VehicleStatus;
import main.ShareRideApp.domain.User.UserDetails;

public abstract class Vehicle {

	final String registrationNo;
	private UserDetails user;
	private main.ShareRideApp.Constants.VehicleType VehicleType;
	private VehicleStatus status ;
	
	public Vehicle(String registrationNo, UserDetails user, main.ShareRideApp.Constants.VehicleType VehicleType) {
		this.registrationNo = registrationNo;
		this.user = user;
		this.VehicleType = VehicleType;
		this.status = VehicleStatus.ACTIVE;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}

	public UserDetails getUser() {
		return user;
	}


	public main.ShareRideApp.Constants.VehicleType getVehicleType() {
		return VehicleType;
	}

	public void setVehicleType(main.ShareRideApp.Constants.VehicleType vehicleType) {
		VehicleType = vehicleType;
	}

	public VehicleStatus getStatus() {
		return status;
	}


	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) obj;
		return Objects.equals(this.registrationNo, other.getRegistrationNo());
	}
	
	
	
}
