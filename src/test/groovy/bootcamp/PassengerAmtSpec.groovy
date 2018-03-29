package bootcamp

import spock.lang.Specification;

class PassengerAmtSpec extends Specification {
	
	def "Receive current location and send available destinations"() {
		given: "A location"
		String location = "LA";
		when: "the location is received"
		then: "return available destinations and trains"
		String possibleLocations = TrainStation.possibleDestinations(location);
		possibleLocations.equals("Denver, Seattle, Houston");
	}
	
	def "Receive an invalid location and prompt for valid location"() {
		given: "An invalid location"
//		TrainStation fakeTrainStation = Stub(TrainStation);
//		fakeTrainStation.getLocation() >> "awdwdadwawd";
		String location = "Alabama";
		when: "the location is received"
		then: "return invalid location and prompt user for new location"
		String possibleLocations = TrainStation.possibleDestinations(location);
		possibleLocations.equals("Invalid location. Please select a new location.");
	}
	
	def "Receive destination and passenger amount"() {
		given: "Destination and passenger amount"
		String destination = "Atlanta";
		String location = "Miami";
		int partySize = 4;
		when: "destination is valid"
		TrainStation trainStationInstance = new TrainStation("atlanta", 50);
		TrainStation fakeTrainStation = Stub(TrainStation.class);
		fakeTrainStation.validateDestination(destination, location) >> true;
		boolean isValid = trainStationInstance.validateDestination(destination.toLowerCase(), location.toLowerCase());
		and: "seats are available"
		boolean isAvailable = trainStationInstance.validateSeatCount(partySize);
		then: "send confirmation message"
		if (isAvailable) {
			System.out.println("Confirmed");
		} else {
			System.out.println("Train is full.");
		}
		
	}

}
