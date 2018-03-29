package bootcamp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;


import org.springframework.stereotype.Component;

@Component("db")
public class TrainDatabase {
	
	public static Map<String, ArrayList<TrainStation>> trainDatabase;
	@PostConstruct
	public static void setDatabase() {
		
		Map<String, ArrayList<TrainStation>> trainMap = new HashMap<>();
		TrainStation atlanta = new TrainStation("atlanta", 50);
		TrainStation seattle = new TrainStation("seattle", 50);
		TrainStation houston = new TrainStation("houston", 50);
		TrainStation newyork = new TrainStation("new york", 50);
		TrainStation miami = new TrainStation("miami", 50);
		TrainStation chicago = new TrainStation("chicago", 50);
		TrainStation denver = new TrainStation("denver", 50);
		TrainStation la = new TrainStation("la", 50);
		
		ArrayList atlDestinations = new ArrayList<TrainStation>();
		atlDestinations.add(miami);
		atlDestinations.add(houston);
		atlDestinations.add(newyork);
		atlDestinations.add(denver);
		atlDestinations.add(chicago);
		
		atlanta.setDestinations(atlDestinations);
		
		//TrainStation[] seattleDestinationsList = new TrainStation[] {la, chicago, denver};
		ArrayList<TrainStation> seattleDestinations = new ArrayList<TrainStation>();
		seattleDestinations.add(la);
		seattleDestinations.add(chicago);
		seattleDestinations.add(denver);
		
		seattle.setDestinations(seattleDestinations);
		
		ArrayList<TrainStation> denverDestinations = new ArrayList<TrainStation>();
		denverDestinations.add(la);
		denverDestinations.add(chicago);
		denverDestinations.add(houston);
		denverDestinations.add(seattle);
		denverDestinations.add(atlanta);
		
		
		ArrayList<TrainStation> chicagoDestinations = new ArrayList<TrainStation>();
		chicagoDestinations.add(la);
		chicagoDestinations.add(houston);
		chicagoDestinations.add(seattle);
		chicagoDestinations.add(atlanta);
		chicagoDestinations.add(newyork);
		
		
		ArrayList<TrainStation> miamiDestinations = new ArrayList<TrainStation>();
		miamiDestinations.add(atlanta);
		miamiDestinations.add(houston);
		
		ArrayList<TrainStation> laDestinations = new ArrayList<TrainStation>();
		laDestinations.add(seattle);
		laDestinations.add(houston);
		laDestinations.add(denver);
		
		ArrayList<TrainStation> newyorkDestinations = new ArrayList<TrainStation>();
		newyorkDestinations.add(seattle);
		newyorkDestinations.add(houston);
		newyorkDestinations.add(denver);
		
		
		
		
		HashMap<String, ArrayList<TrainStation>> db = new HashMap<>();
		
		db.put("atlanta", atlDestinations);
		db.put("miami",  miamiDestinations);
		db.put("seattle", seattleDestinations);
		db.put("denver", denverDestinations);
		db.put("chicago", chicagoDestinations);
		db.put("la", laDestinations);
		db.put("newyork", newyorkDestinations);
		
		TrainDatabase.trainDatabase = db;
		
	}
	
}
