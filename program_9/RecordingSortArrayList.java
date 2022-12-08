import java.util.InputMismatchException;
import java.util.*;
public class RecordingSortArrayList2 {

	public static void main(String[] args) {
		
		//scanner object for input
		Scanner keyboard = new Scanner(System.in);
		
		//create an array with recording objects
		int numRec = 5;
		ArrayList<Recording> recordingsArray = new ArrayList<>(numRec);
		createArray(recordingsArray, keyboard, numRec);  //call the createArray method 
		
		//control variable
		char choice;
		do {
			 choice = displayMenu(keyboard);
			 
			
			//sort array
			sortArray(choice, recordingsArray);
			
		}
		while(choice != 'd');
		
		

	}
	/**
	 * The createArray method creates fills an array of Recording objects
	 * @param recordingsArray the reference to the recordingsArray array
	 * @param keyboard Scanner object for input
	 * @return the recordingsArray
	 */
	public static ArrayList <Recording> createArray(ArrayList<Recording> recordingsArray, Scanner keyboard, int numRec) {
		
		System.out.println("Enter the details for each record: ");
		for (int i = 0; i < numRec; i++) {
			//get the details for each recording
			System.out.println("Recording" + (i + 1) + ": ");
			System.out.print("Record Title: ");
			String title = keyboard.nextLine();
			System.out.print("Artist Name: ");
			String artist = keyboard.nextLine();
			double playingTime;
			System.out.print("Playing Time: ");
		
				//catch an input mismatch exception
				try {
					playingTime = keyboard.nextDouble();
					while (playingTime < 0) {
						System.out.print("Invalid entry, please reenter: ");
						playingTime = keyboard.nextDouble();
						keyboard.nextLine();//clear buffer
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Invalid input. playing time saved as 0.0. ");
					playingTime = 0;
			}
			
			keyboard.nextLine();////////////////////clear buffer
			
			//create recording object and add it to array
			recordingsArray.add(new Recording(title, artist, playingTime));
		
	}
		return recordingsArray;
	}
	
	/**
	 * the displayMenu method displays a menu on how to sort the recordings
	 * @param keyboard Scanner object for input
	 * @return choice, the users decision
	 */
	public static char displayMenu(Scanner keyboard){
		//display a menu on how to sort the recordings
		System.out.println("Sort recording by: ");
		System.out.println("a. Song title");
		System.out.println("b. Artist");
		System.out.println("c. Playing time ");
		System.out.println("d. Exit ");
		
		//get users choice for menu
		System.out.print("Select how you want to sort the recordings: ");
		char choice = keyboard.nextLine().charAt(0);
		//validate users choice is from menu
		while(choice != 'a' && choice != 'b' && choice != 'c' && choice != 'd') {
			System.out.println("You entered an invalid choice, reenter a choice from the menu: ");
			choice = keyboard.nextLine().charAt(0);
		}
		
	return choice;
	}
	
	/**
	 * the sortArray method calls a specific sort method according to users choice
	 * @param choice users choice on how to sort method
	 * @param recordingsArray reference to the array of recording objects
	 */
	public static void sortArray(int choice, ArrayList <Recording> recordingsArray) {
		
		//switch statement to sort array based on choice
		switch (choice) 
		{
		case 'a':
			sortByTitle(recordingsArray);
			break;
		case 'b':
			sortByArtist(recordingsArray);
			break;
		case 'c':
			sortByPlayingTime(recordingsArray);
			break;
		case 'd':
			System.out.println("You chose to exit.");
		}
	}
	
	/**
	 * the sortByTitle method sorts and displays the recordings by title
	 * @param recordingsArray reference to the array of Recording objects
	 */
	public static void sortByTitle(ArrayList<Recording> recordingsArray) {
		int numRec = 5;
		   for(int a = 0; a < (numRec - 1); a++)
		      {
		         for(int b = a + 1; b < numRec; b++)
		         {
		             //automatically compare in upper case so both are same
		            if(recordingsArray.get(a).getTitle().toUpperCase().compareTo(recordingsArray.get(b).getTitle().toUpperCase()) > 0) {
		            	Recording temp = recordingsArray.get(a);
		            	recordingsArray.set(a, recordingsArray.get(b));
		            	recordingsArray.set(b, temp);
		            }
		         }
		      }
		   
		   System.out.println("recordings sorted by title: ");
		   for (int i = 0; i < numRec; i++) {
		      System.out.println((i+1) + ": " + recordingsArray.get(i).getTitle());
		   }
	}
	
	/**
	 * the sortByArtist method sorts and displays the recordings by artist
	 * @param recordingsArray reference to the array of Recording objects
	 */
	public static void sortByArtist(ArrayList <Recording> recordingsArray) {
		int numRec = 5;
		   for(int a = 0; a < (numRec - 1); a++)
		      {
		         for(int b = a + 1; b < numRec; b++)
		         {
		            
		            if(recordingsArray.get(a).getArtist().toUpperCase().compareTo(recordingsArray.get(b).getArtist().toUpperCase()) > 0){
		            	Recording temp = recordingsArray.get(a);
		            	recordingsArray.set(a, recordingsArray.get(b));
		            	recordingsArray.set(b, temp);
		            }
		         }
		      }
		   System.out.println("recordings sorted by Artist: ");
		   for (int i = 0; i < numRec; i++) {
			      System.out.println((i+1) + ": " + recordingsArray.get(i).getTitle() + "(Artist name: " + recordingsArray.get(i).getArtist() + ")");
			   }
		   }
	
	/**
	 * the sortByPlayingTime method sorts and displays the recordings by playingTime
	 * @param recordingsArray reference to the array of Recording objects
	 */
	public static void sortByPlayingTime(ArrayList <Recording> recordingsArray) {
		int numRec = 5;
		   for(int a = 0; a < (numRec - 1); a++)
		      {
		         for(int b = a + 1; b < numRec; b++)
		         {
		            if(recordingsArray.get(a).getPlayingTimeAsString().compareTo(recordingsArray.get(b).getPlayingTimeAsString()) > 0){
		            	 Recording temp = recordingsArray.get(a);
			               recordingsArray.set(a, recordingsArray.get(b));
			               recordingsArray.set(b, temp);
		            }
		         }
		      }
		   
		   System.out.println("recordings sorted by Playing Time: ");
		   for (int i = 0; i < numRec; i++) {
			   	System.out.printf("%d. %s (Playing Time: %.2f) %n", (i+1), recordingsArray.get(i).getTitle(), recordingsArray.get(i).getPlayingTime() );
			   }
		   }

	

	

}
