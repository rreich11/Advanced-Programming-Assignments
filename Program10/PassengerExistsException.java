package Program10;

public class PassengerExistsException extends RuntimeException{/////check which exception should extend!!!!!!
	
	/**
	 * no-arg constructor to throw a PassengerExistsException. Passes message "Error, 
	 * passenger already exists." to superclass constructor
	 */
	public PassengerExistsException() {
		super("Error, passenger already exists. ");
	}
	
	/**
	 * Constructor that accepts a message to pass to the superclass constructor
	 * @param message the message the user will see when an exception is thrown, 
	 * if uses getMessage() method
	 */
	public PassengerExistsException(String message) {
		super(message);
	}
	
}

