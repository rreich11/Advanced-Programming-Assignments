package Program10;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	
	/**
	 * 
	 * @param street sets the street
	 * @param city sets the city
	 * @param state sets the state.
	 * @param zip sets the zip
	 */
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zip;
	}
	
	/**
	 * the getStreet method returns the street name
	 * @return The String in street field
	 */
	public String getStreet() {
		return street;
	}
	
	
	/**
	 * the getCity method returns the city name
	 * @return The string in city field
	 */
	public String getCity() {
		return city;
	}	
	
	/**
	 * the getState method returns the State name
	 * @return The String in state field
	 */
	public String getState() {
		return state;
	}
	
	
	/**
	 * the getZip method returns the zipcode
	 * @return the String in zipcode field
	 */
	public String getZip() {
		return zipcode;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Street: " + street + "\nCity: " + city + "\nState: " + state + "\nZipcode: " + zipcode);
		return sb.toString();
	}
	
	}

