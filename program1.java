import java.util.Scanner;  // Needed for the Scanner class

/*this program calculates the occupancy rate of a hotel*/

public class program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
    // Create a Scanner object to read input.
    Scanner keyboard = new Scanner(System.in);
    
    int floor;                 //number of floors in hotel
    double numRoomsFloor;      //number of rooms per floor
    double numOccupied;        //number of rooms occupied on the floor
    int i;                     //loop control
    double totalNumRooms;      //Total number of rooms hotel has
    double totalOccupiedRooms; //total number of occupied rooms
    double vacantRooms;        //number of rooms that are vacant
    double occupancyRate;      //occupancy rate as decimal
    double occupancyRatePercent;     //occupancy rate in percent
    
    
    //Get the number of floors
    System.out.print("How many foors are there in the hotel? ");
    floor = keyboard.nextInt();
    
	//validate floor greater than zero
	while (floor < 1 ) {
		System.out.print("Invalid, you must enter at least 1 floor. Please reenter: ");
		floor = keyboard.nextInt();
	}
	
	//initialize variable to hold total number of rooms and total number of occupied rooms
	totalNumRooms = 0;
	totalOccupiedRooms = 0;
    
    //loop for each floor of hotel
    for (i = 1; i <= floor; i++) {
    	//find out how many rooms on the floor
    	System.out.print("How many rooms are on floor " + i + "? ");
    	numRoomsFloor = keyboard.nextInt();
    	
    	//validate at least 10 rooms on floor
    	while (numRoomsFloor < 10 ) {
    		System.out.print("Invalid, you must enter at least 10 rooms per floor. Please reenter: ");
    		numRoomsFloor = keyboard.nextInt();
    	}
    		
    	//get number of occupied rooms
    	System.out.print("How many of the rooms on floor " + i + " are occupied? ");
    	numOccupied = keyboard.nextInt();
    	
    	//validate that not more rooms occcupied than number of rooms
    	while (numOccupied > numRoomsFloor ) {
    		System.out.print("Invalid, the number of rooms occupied cannot be greater than number of rooms on floor. Please reenter: ");
    		numOccupied = keyboard.nextInt();    	}
    	
    //add rooms from floor to total number of rooms	
    totalNumRooms += numRoomsFloor;
    //add occupied rooms to total occupied rooms
    totalOccupiedRooms += numOccupied;   
    }
    
   //calculate number of vacant rooms 
   vacantRooms = totalNumRooms - totalOccupiedRooms;
   //calculate occupancy rate
   occupancyRate = totalOccupiedRooms / totalNumRooms;
   //calculate occupancy as a percentage
   occupancyRatePercent = occupancyRate * 100;
   
   
   //display hotel capacity
   System.out.println();
   System.out.println("Here is what the capacity of your hotel looks like today:");
   System.out.printf("Number of rooms in hotel: %,.0f\n" ,totalNumRooms);
   System.out.printf("Number of occupied rooms: %,.0f\n", totalOccupiedRooms);
   System.out.printf("Number of vacant rooms: %,.0f\n", vacantRooms);
   System.out.printf("Occupancy Rate for the hotel: %.2f", occupancyRate);
   System.out.printf(" (%.0f", occupancyRatePercent);
   System.out.print("%)");
   
    
  
	}

}
