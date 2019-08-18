package main.ShareRideApp.Constants;

import main.ShareRideApp.service.RideSelectionStrategy;
import main.ShareRideApp.serviceImpl.MostVacentSelectionStrategy;

public class ApplicationConstants {

	public static final RideSelectionStrategy defaultRideSelectionStrategy = new MostVacentSelectionStrategy();
}
