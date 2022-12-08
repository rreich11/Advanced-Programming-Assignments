package Program10;
import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private Gender gender;
	private LocalDate birthdate;
	private Address address;
	
	/**
	 * Constructor
	 * @param fname first name of person, String
	 * @param lname last name of person, String
	 * @param g gender of person, Gender
	 * @param add address of person, Address
	 * @param birthdate birthdate of person, String
	 */
	public Person(String fname, String lname, Gender g, Address add, String birthdate) {
		this.firstName = fname;
		this.lastName = lname;
		this.gender = g;
		this.address = add;
		LocalDate birthday = LocalDate.parse(birthdate);
		this.birthdate = birthday;
	}
	
	/**
	 * Constructor
	 * @param fname first name of person, String
	 * @param lname last name of person, String
	 * @param g, gender of person, Gender
	 * @param street street of person String
	 * @param city city of person String
	 * @param state state of person, String
	 * @param zip zip of person, String
	 * @param birthdate birthdate of person, String
	 */
	public Person(String fname, String lname, Gender g, String street, String city, String state, String zip, String birthdate) {
		this(fname, lname, g, new Address(street, city, state, zip), birthdate);
	}
	
	/**
	 * Constructor
	 * @param fname first name of person, String
	 * @param lname last name of person, String
	 * @param g gender of person. Gender
	 * @param add address of person, Address
	 * @param birthdate birthday of person, LocaDate
	 */
	public Person(String fname, String lname, Gender g, Address add, LocalDate birthdate) {
		this.firstName = fname;
		this.lastName = lname;
		this.gender = g;
		this.address = add;
		this.birthdate = birthdate;
	}
	
	/**
	 * Copy Constructor
	 * @param p the person object to copy
	 */
	public Person(Person p) {
		this(p.getFirstName(), p.getLastName(), p.getGender(), p.getAddress(), p.getBirthdate());
	}

	/**
	 * method to get the first name
	 * @return the first name as String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * method to get last name
	 * @return the last name as String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * method to return the gender
	 * @return return the gender as Gender
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * method to return the birthdate
	 * @return the birthdate as a LocalDate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	/**
	 * method to get the address
	 * @return the addrees as Address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * method to set the last name
	 * @param last last name as String
	 */
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	/**
	 * method to set the address
	 * @param addr the Address object to set address
	 */
	public void setAddress(Address addr) {
		this.address = addr;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nGender: " + gender + 
				"\nBirthdate: " + birthdate + "\nAddress: " + address);
		return sb.toString();
		}
	

	@Override
	/**
	 * equals method to compare person based on first name, last name, and birthdate
	 * @param obj the person object to compare
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (this.firstName != other.firstName)
			return false;
		if(this.lastName != other.lastName)
			return false;
		if(this.birthdate != other.birthdate)
			return false;
		return true;
	}	
}