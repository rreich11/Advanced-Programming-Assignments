package Program10;


public class Passenger extends Person {
	
	private String passportID;
	private int luggagePieces;
	
	/**
	 * constuctor
	 * @param f first name of person
	 * @param l last name of person
	 * @param g gender of person
	 * @param addr address of person
	 * @param birthdate birthdate of person
	 * @param passport passport ID of person
	 * @param luggage number of luggage for person
	 */
	public Passenger(String f, String l, Gender g, Address addr, String birthdate, String passport, int luggage){
		super(f, l, g, addr, birthdate);
		this.passportID = passport;
		this.luggagePieces = luggage;
	}
	
	/**
	 *  Copy constructor
	 * @param p the Person object that is being copied
	 */
	public Passenger(Passenger p) {
		super(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate());
		this.passportID = p.passportID;
		this.luggagePieces = p.luggagePieces;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\nPassport ID: " + passportID + "\nLuggage Pieces: " + luggagePieces);
		 return sb.toString();	
	}

	@Override
	/**
	 * equals Method to compare two passengers by their passport ID
	 * @param obj the object to compare
	 * @return the boolean value if equals or not
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if(!this.passportID.equals(other.passportID))
			return false;
		return true;
	}
	
	
	
	
}
