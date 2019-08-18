package main.ShareRideApp.domain.ride;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import main.ShareRideApp.domain.Address;
public abstract class Ride {
	
	private Address sourceAddress;
	private Address destAddress;
	private Timestamp creationTime;
	
	public Ride(Address source, Address dest){
		this.sourceAddress = source;
		this.destAddress = dest;
		this.creationTime = new Timestamp(new Date().getTime());
	}

	public Address getSourceAddress() {
		return sourceAddress;
	}


	public Address getDestAddress() {
		return destAddress;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destAddress, sourceAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Ride)) {
			return false;
		}
		Ride other = (Ride) obj;
		
		if(Objects.equals(destAddress, other.destAddress) && 
				Objects.equals(sourceAddress, other.sourceAddress)
				) {
			
						return true;
		}
		return false;
	}



	
	
	
	
	
	
	
	
	
	

}
