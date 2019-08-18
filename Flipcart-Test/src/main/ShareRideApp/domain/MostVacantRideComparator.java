package main.ShareRideApp.domain;

import java.util.Comparator;

import main.ShareRideApp.domain.ride.RideDetails;

public class MostVacantRideComparator implements Comparator<RideDetails>{

	@Override
	public int compare(RideDetails o1, RideDetails o2) {
			return o2.getAvailableSeats() - o1.getAvailableSeats();
	}

}
