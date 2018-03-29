package bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;

public class TrainStation {
	
	private String location;
	private int passengerCount;
	private List<TrainStation> destinations;
	public static Map<String, ArrayList<TrainStation>> trainDatabase;
	{
		Map<String, ArrayList<TrainStation>> trainMap = new HashMap<>();
		TrainStation atlanta = new TrainStation("atlanta", 50);
		TrainStation seattle = new TrainStation("seattle", 50);
		TrainStation houston = new TrainStation("houston", 50);
		TrainStation newyork = new TrainStation("new york", 50);
		TrainStation miami = new TrainStation("miami", 50);
		TrainStation chicago = new TrainStation("chicago", 50);
		TrainStation denver = new TrainStation("denver", 50);
		TrainStation la = new TrainStation("la", 50);
		
		List atlDestinations = new ArrayList<TrainStation>();
		atlDestinations.add(miami);
		atlDestinations.add(houston);
		atlDestinations.add(newyork);
		atlDestinations.add(denver);
		atlDestinations.add(chicago);
		
		atlanta.setDestinations(atlDestinations);
		
		TrainStation[] seattleDestinationsList = new TrainStation[] {la, chicago, denver};
		List seattleDestinations = new ArrayList<TrainStation>();
		seattleDestinations.addAll(Arrays.asList(seattleDestinations));
		
		seattle.setDestinations(seattleDestinations);
		
		TrainStation[] denverDestinationsList = new TrainStation[] {la, chicago, houston, seattle, atlanta};
		List denverDestinations = new ArrayList<TrainStation>();
		denverDestinations.addAll(Arrays.asList(denverDestinations));
		
		TrainStation[] chicagoDestinationsList = new TrainStation[] {la, houston, seattle, atlanta, newyork};
		List chicagoDestinations = new ArrayList<TrainStation>();
		chicagoDestinations.addAll(Arrays.asList(chicagoDestinations));
		
		TrainStation[] miamiDestinationsList = new TrainStation[] {atlanta, houston};
		List miamiDestinations = new ArrayList<TrainStation>();
		miamiDestinations.addAll(Arrays.asList(miamiDestinations));
		
		
		
		HashMap<String, ArrayList<TrainStation>> db = new HashMap<>();
		
		db.put("atlanta", (ArrayList<TrainStation>) atlDestinations);
		db.put("miami", (ArrayList<TrainStation>) miamiDestinations);
		db.put("seattle", (ArrayList<TrainStation>) seattleDestinations);
		db.put("denver", (ArrayList<TrainStation>) denverDestinations);
		db.put("chicago", (ArrayList<TrainStation>) chicagoDestinations);
		
		TrainStation.trainDatabase = db;
		
	}
	
	
	
	
	
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
	
	public boolean validateDestination(String destination, String location) {
		ArrayList<TrainStation> locationDestinations = TrainStation.trainDatabase.get(location);
		
		for (TrainStation station : locationDestinations) {
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
