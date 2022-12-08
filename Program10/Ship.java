package Program10;

import java.time.LocalDate;

public class Ship {
	private String shipName;
	private int yearBuilt;
	
	/**
	 * no-arg constructor
	 */
	public Ship() {
		this("Unknown", 2000);
	}
	
	/**
	 * constructor
	 * @param shipName the name of ship
	 */
	public Ship(String shipName) {
		this(shipName, 2000);
	}
	
	/**
	 * constructor
	 * @param yearBuilt year the ship was built
	 */
	public Ship(int yearBuilt) {
		this("Unknown", yearBuilt);
	}
	
	/**
	 * constructor
	 * @param shipName name of ship
	 * @param yearBuilt year ship was built
	 */
	public Ship(String shipName, int yearBuilt) {
		this.shipName = shipName;
		if (yearBuilt < 1900 || yearBuilt > LocalDate.now().getYear()){
			this.yearBuilt = 2000;
		}
		this.yearBuilt = yearBuilt;
	}
	
	/**
	 * method to set name of ship
	 * @param name name of ship as String
	 */
	public void setShipName(String name) {
		this.shipName = name;
	}
	
	/**
	 * method to set the year ship was built
	 * @param year the year ship was built as int
	 */
	public void setYearBuilt(int year) {
		if (year < 1900 || year > LocalDate.now().getYear()){
			this.yearBuilt = 2000;
		}
		this.yearBuilt = year;
	}
	
	/**
	 * method to get the ships name
	 * @return the name of ship as String
	 */
	public String getShipName() {
		return shipName;
	}
	
	/**
	 *  method to get the year ship was built 
	 * @return the year ship was built as int
	 */
	public int getYearBuilt() {
		return yearBuilt;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nShip Name: " + shipName + "\nYear Built: " + yearBuilt);
		return sb.toString();
	}
		
	
}
