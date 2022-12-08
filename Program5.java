import java.util.Scanner;
import java.io.*;

public class Program5 {

	public static void main(String[] args) throws IOException {
		//create array to hold world series winners
		String[] winners = new String[150];
		int qty = 0;
		String filename = "WorldSeriesWinners.txt";

		//create scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		try {
			//open file to read from
			File file = new File(filename);
			Scanner inputFile = new Scanner(file);

			//read file into array and keep track of filled elements
			qty = createArray(winners, qty, inputFile);
			

			String again;

			do {
				//get the team name from user
				System.out.print("Enter a team name: ");
				String teamName = keyboard.nextLine();

				//variable to hold number of times team won
				int teamWon = 0;
				
				
				//if the team is in array, add one to teamWon
				for (int i = 0; i < qty; i++) {
					if (teamName.equalsIgnoreCase(winners[i])) {
						teamWon++;
					}
				}

				
				//if team entered did not win, display message otherwise, display number of times won
				if (teamWon == 0){
					System.out.println("The team " + teamName + " did not win any world series from 1903-2009. ");
				}

				else {
					displayNumWins(teamName, teamWon);
				}
				
				//let user enter another team name if they want, otherwise end program
				System.out.print("Do you want to find another team? yes/no ");
				again = keyboard.nextLine();
			}
			while( again.equalsIgnoreCase("yes"));

			inputFile.close();

		}
		//catch possible exception and display message
		catch(FileNotFoundException | ArrayIndexOutOfBoundsException e) {

			System.out.println(e.getMessage());
		}
		keyboard.close();

	}

	public static int createArray(String[] winners, int qty, Scanner inputFile) throws IOException{	
		//read file into array
		while (inputFile.hasNext() && qty < winners.length) {
			winners[qty] = inputFile.nextLine();
			//increment counter for filled elements of array
			qty++;
		}
		//return size of filled array
		return qty;

	}

	public static void displayNumWins(String teamName, int teamWon) {
		System.out.printf("The %s won %d time(s) from the years 1903-2009.", teamName, teamWon);
	}

}

