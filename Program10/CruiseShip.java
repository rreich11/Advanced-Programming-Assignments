package Program10;
import java.util.ArrayList;

public class CruiseShip extends Ship {

	private int maxPassenger;
	private ArrayList<Passenger> passengers = new ArrayList<>(maxPassenger);
	
	
	/**
	 * Constructor
	 * @param name sets the ship name
	 * @param built sets the yearBuilt
	 * @param maxPassenger sets the maximum number of passengers
	 * @param passengers sets the array list of passengers
	 */
	public CruiseShip(String name, int built, int maxPassenger, ArrayList<Passenger> passengers) {
		super(name, built);
		this.maxPassenger = maxPassenger;
		this.passengers = passengers;
	}
	
	/**
	 * Constructor
	 * @param maxPassenger sets the maximum number of passengers
	 * @param passengers sets the array list of passengers
	 */
	public CruiseShip(int maxPassenger, ArrayList<Passenger> passengers) {
		this.maxPassenger = maxPassenger;
		this.passengers = passengers;
	}
	
	/**
	 * Constructor
	 * @param passengers sets the array list of passengers
	 */
	public CruiseShip(ArrayList<Passenger> passengers) {
		this(0, passengers);
	}
	
	/**
	 * the setMaxPassengers sets the max number of passengers on boat
	 * @param max
	 */
	public void setMaxPassengers(int max) {
		this.maxPassenger = max;
	}
	
	/**
	 * the setPassengers method sets the ArrayList of passengers
	 * @param passengers the ArrayList to store passengers
	 */
	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	/**
	 * this method gets the maximum number of passengers
	 * @return maximum number of passengers
	 */
	public int getMaxPassengers() {
		return maxPassenger;
	}
	
	/**
	 * this method returns a copy of the arrayList of passengers
	 * @return the copy of array List of passengers
	 */
	public ArrayList<Passenger> getPassengers(){
		ArrayList<Passenger> passengersCopy = new ArrayList<>();
		for (int i = 0; i < passengers.size(); i++) {
			passengersCopy.add(i, passengers.get(i));
		}
		return passengersCopy;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\nMaximum Passengers: " + maxPassenger +  
				"\n Passengers: " + passengers);
		return sb.toString();
	}
	
	/**
	 * this method adds a passenger to the array List of passengers
	 * @param passengers arrayList of passengers
	 * @param passenger Passenger object to be added to array list
	 * @return the array List with added passenger
	 */
	public ArrayList<Passenger> addPassenger(ArrayList <Passenger> passengers, Passenger passenger){
		for(int i = 0; i < passengers.size(); i++) {
			if(passenger.equals(passengers.get(i))) {
			throw new PassengerExistsException();

			}
			else {
			passengers.add(passenger);
			}
		}
		return passengers;
}
}
