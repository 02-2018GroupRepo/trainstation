package bootcamp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;

public class TrainStation {
	
	private String location;
	private int passengerCount;
	private List<TrainStation> destinations;
	
	
	public static String possibleDestinations(String location) {
		switch (location.toLowerCase()) {
			case "seattle": 
				return "LA, Denver, Chicago";
			case "la":
				return "Denver, Seattle, Houston";
			case "denver":
				return "LA, Seattle, Chicago, Houston, Atlanta";
			case "chicago":
				return "LA, Seattle, New York, Houston, Atlanta";
			case "atlanta":
				return "Miami, Houston, New York, Denver, Chicago";
			case "houston":
				return "Denver, Atlanta, Miami";
			case "new york":
				return "Chicago, Atlanta";
			default:
				return "Invalid location. Please select a new location.";		
		}
	}
	
	public static boolean validateDestination(String destination, String location) {
		ArrayList<TrainStation> locationDestinations = TrainDatabase.trainDatabase.get(location);
		
		for (TrainStation station : locationDestinations) {
			System.out.println(station.getLocation());
			System.out.println(destination);
			if (station.getLocation().equalsIgnoreCase(destination)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public TrainStation(String location, int passengerCount) {
		super();
		this.location = location;
		this.passengerCount = passengerCount;
	}
	
	public boolean validateSeatCount(int partySize) {
		if (this.passengerCount - partySize >= 0) {
			return true;
		} 
		return false;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPassengerAmt() {
		return passengerCount;
	}
	public void setPassengerAmt(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public List<TrainStation> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<TrainStation> destinations) {
		this.destinations = destinations;
	}
	

}

