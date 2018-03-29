package bootcamp.dao;

public class ReserveTrainJson {
	
	private String destination;
	private int seatCount;
	
	public ReserveTrainJson(String destination, int seatCount) {
		super();
		this.destination = destination;
		this.seatCount = seatCount;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	
}
