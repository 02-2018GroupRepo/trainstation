package bootcamp;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.assertj.core.util.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainDatabase {
	
	public static int test = 3;
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
		
		TrainDatabase.trainDatabase = db;
		
	}
}


//switch (location.toLowerCase()) {
//case "seattle": 
//	return "LA, Denver, Chicago";
//case "la":
//	return "Denver, Seattle, Houston";
//case "denver":
//	return "LA, Seattle, Chicago, Houston, Atlanta";
//case "chicago":
//	return "LA, Seattle, New York, Houston, Atlanta";
//case "atlanta":
//	return "Miami, Houston, New York, Denver, Chicago";
//case "houston":
//	return "Denver, Atlanta, Miami";
//case "new york":
//	return "Chicago, Atlanta";
//default:
//	return "Invalid location. Please select a new location.";		
//}