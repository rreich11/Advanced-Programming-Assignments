package Program10;
import java.time.LocalDate;
import java.util.*;

public class Program10 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		//create an arrayList of cruise ships
		ArrayList<CruiseShip> cruiseShips = new ArrayList<>();
		//create an arrayList of cargo Ships
		ArrayList<CargoShip> cargoShips = new ArrayList<>();
		
		//add to arrayList of cruise Ships
		addCruiseShipToArray(cruiseShips, keyboard);
		
		//add to array List of Cargo Ships
		addCargoShipToArray(cargoShips, keyboard);
		
		//display the details of the cargo ship and the cruise Ship
		System.out.println("Cruise Ships: ");
		System.out.println(cruiseShips);
		System.out.println("Cargo Ships: ");
		System.out.println(cargoShips);
		
	}
	
	/**
	 * a method that creates a cruiseShip object, fills it with passengers and returns it
	 * @param keyboard Scanner object for input
	 * @return the cruiseShip object
	 */
	public static CruiseShip createCruiseShip( Scanner keyboard) {
		System.out.println("Enter the information for the cruise ship: ");
		System.out.print("Cruise Ship Name: ");
		String cruiseShipName = keyboard.nextLine();
		System.out.print("Year Built: ");
		int yearBuilt = keyboard.nextInt();
		while(yearBuilt < 1900 || yearBuilt > LocalDate.now().getYear()) {
			System.out.print("Invalid, please reenter the year built: ");
			yearBuilt = keyboard.nextInt();
		}
		System.out.print("Maximum Passengers: ");
		int maxPassengers = keyboard.nextInt();
		while(maxPassengers < 0 || maxPassengers > 300000) {
			System.out.print("Invalid, please reenter the maximum number of passengers: ");
			maxPassengers = keyboard.nextInt();
		}
		//create an arrayList of passengers for the cruise Ship
		ArrayList<Passenger> cruiseShipPassengers = new ArrayList<Passenger>();
		//create the cruiseShip object
		CruiseShip cruiseShip = new CruiseShip(cruiseShipName, yearBuilt, maxPassengers, cruiseShipPassengers);
		
		//call method that adds passengers to the cruise ship
		addCruiseShipPassengers(cruiseShipPassengers, cruiseShip, keyboard);	
		
		return cruiseShip;
	}
	
	/**
	 * a method that adds a Passenger to the cruiseShipPassengers arrayList
	 * @param cruiseShipPassengers the ArrayList of passengers
	 * @param keyboard the Scanner object for input
	 * @param cruiseShip the CruiseShip object
	 */
	public static void addCruiseShipPassengers(ArrayList<Passenger> cruiseShipPassengers, CruiseShip cruiseShip, Scanner keyboard) {
		keyboard.nextLine();//clear buffer
		System.out.print("Do you want to add a passenger to the cruise Ship? y/n ");
		char choice = keyboard.nextLine().toUpperCase().charAt(0);
		while (choice == 'Y') {
			Passenger passenger = newPassenger(keyboard);
			try {
				cruiseShip.addPassenger(cruiseShipPassengers, passenger);
				keyboard.nextLine();//clear buffer
			}
			catch(PassengerExistsException e) {
				System.out.println(e.getMessage());
			}
			
			
			System.out.print("Would you like to add another passenger?  y/n ");
			choice = keyboard.nextLine().toUpperCase().charAt(0);
		}
	}
	
	/**
	 * a method to add cruise ships to the Cruise ship Array List
	 * @param cruiseShips the arrayList of cruiseShips
	 * @param keyboard the Scanner object for input
	 */
	public static void addCruiseShipToArray(ArrayList<CruiseShip> cruiseShips, Scanner keyboard) {
		System.out.print("Do you want to add a Cruise Ship to the cruise Ship Array? y/n ");
		char choice = keyboard.nextLine().toUpperCase().charAt(0);
		while (choice == 'Y') {
			CruiseShip cruiseShip = createCruiseShip(keyboard);
			cruiseShips.add(cruiseShip);
			System.out.print("Would you like to add another Cruise Ship?  y/n ");
			choice = keyboard.nextLine().toUpperCase().charAt(0);
		}
	}
	

	
	/**
	 * a method that accepts user input for parameters to create a Passenger object
	 * @return the Passenger object
	 */
	public static Passenger newPassenger(Scanner keyboard) {
		System.out.println("Enter the information for each passenger that will board the ship. ");
		System.out.print("First Name: ");
		String fname = keyboard.nextLine();
		System.out.print("Last Name: ");
		String lname = keyboard.nextLine();
		
		System.out.print("Gender (Enter M or F): ");
		
		String input = keyboard.nextLine().toUpperCase();
		char charInput = input.charAt(0);
		while (charInput != 'M' && charInput != 'F') {
			System.out.print("Invalid, please reenter gender: ");
			 input = keyboard.nextLine().toUpperCase();
			 charInput = input.charAt(0);
		}
		Gender gender = Gender.valueOf(input);
		System.out.print("Street: ");
		Address addr = getAddress(keyboard);
		System.out.print("BirthDate (yyyy-mm-dd): ");
		String birthdate = keyboard.nextLine();
		System.out.print("Passport ID: ");
		String passportID = keyboard.nextLine();
		System.out.print("Number of Luggage: ");
		int numLuggage = keyboard.nextInt();
		Passenger passenger = new Passenger(fname, lname, gender, addr, birthdate,passportID, numLuggage);
		return passenger;
	}
	
	/**
	 * a method to create Address object
	 * @return the Address object
	 */
	public static Address getAddress(Scanner keyboard){
		String street = keyboard.nextLine();
		System.out.print("City: ");
		String city = keyboard.nextLine();
		System.out.print("State: ");
		String state = keyboard.nextLine();
		System.out.print("Zip Code: ");
		String zip = keyboard.nextLine();
		Address addr = new Address(street, city, state, zip);
		return addr;
	}
	
	/**
	 * the method to create a cargo ship
	 * @param keyboard the Scanner object for input
	 * @return the CargoShip object
	 */
	public static CargoShip createCargoShip( Scanner keyboard) {
		System.out.println("Enter the information for the Cargo ship: ");
		System.out.print("Cargo Ship Name: ");
		String cargoShipName = keyboard.nextLine();
		System.out.print("Year Built: ");
		int yearBuilt = keyboard.nextInt();
		while(yearBuilt < 1900 || yearBuilt > LocalDate.now().getYear()) {
			System.out.print("Invalid, please reenter the year built: ");
			yearBuilt = keyboard.nextInt();
		}
		System.out.print("Cargo Capacity (in tonnage): ");
		int cargoCapacity = keyboard.nextInt();
		while(cargoCapacity < 0 || cargoCapacity > 300000) {
			System.out.print("Invalid, please reenter the Cargo Capacity of ship: ");
			cargoCapacity = keyboard.nextInt();
		}
		CargoShip cargoShip = new CargoShip(cargoShipName, yearBuilt, cargoCapacity);
		return cargoShip;
	}
	
	/**
	 * a method to add cargo ships to the cargoShip ArrayList
	 * @param cargoShips the cargoShip Array
	 * @param keyboard the Scanner object for input
	 */
	public static void addCargoShipToArray(ArrayList<CargoShip> cargoShips, Scanner keyboard) {
		System.out.print("Do you want to add a Cargo Ship to the Cargo Ship Array? y/n ");
		char choice = keyboard.nextLine().toUpperCase().charAt(0);
		while (choice == 'Y') {
			CargoShip cargoShip = createCargoShip(keyboard);
			cargoShips.add(cargoShip);
			keyboard.nextLine();//clear buffer
			System.out.print("Would you like to add another Cargo Ship?  y/n ");
			choice = keyboard.nextLine().toUpperCase().charAt(0);
		}
	}	
	
}
