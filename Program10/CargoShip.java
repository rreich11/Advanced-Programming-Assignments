package Program10;

public class CargoShip extends Ship {
	private int cargoCapacity;
	
	 /**
	 * Constructor
	 * @param name sets the ship name
	 * @param built sets the yearBuilt
	 * @param capacity sets the cargo capacity
	 */
	public CargoShip(String name, int built, int capacity){
		super(name, built);
		this.cargoCapacity = capacity;
	}
	
	/**
	 * constructor
	 * @param capacity sets the cargoCapacity
	 */
	public CargoShip(int capacity){
		if(capacity < 0) {
			this.cargoCapacity = 0;
		}
		this.cargoCapacity = capacity;
	}
	
	/**
	 * the setCargoCapacity method sets the capacity of cargo
	 * @param capacity  The int to store in cargoCapacity
	 */
	public void setCargoCapacity(int capacity) {
		if (capacity < 0) {
			this.cargoCapacity = 0;
		}
		this.cargoCapacity = capacity;
	}
	
	/**
	 * The getCargoCapacity method returns the cargoCapacity
	 * @return the cargo capacity as int
	 */
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nShip Name: "  + this.getShipName() + "\nCargo Capacity: " + cargoCapacity);
		return sb.toString();
	}
	

	
}
