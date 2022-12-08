import java.util.Scanner; // Needed for the Scanner class
import java.io.*;         // Needed for the File class

public class Program3 {

	public static void main(String[] args) throws IOException{
		
		double totalSum = 0;
		int counter = 0;
		double firstNum = 0;
		double highestNum = firstNum;
		double lowestNum = firstNum;
		double average;
		
		//open the file to read from
		File file = new File("Numbers.txt");
		Scanner inputFile = new Scanner(file);
		
		//read the whole file
		while(inputFile.hasNext()) {
			double number = inputFile.nextDouble();
		    	
		    	//get the first number in the list 
		    	if (counter == 0) {
		    		firstNum = number;
		    	}
		    	
		    	//add the number read to sum of numbers
		    	totalSum = totalSum + number;
		    	
		    	//get the highest number in the list
		    	if (number > highestNum) {
		    		highestNum = number;
		    	}
		    	
		    	//get the lowest number in the list
		    	if(number < lowestNum) {
		    		lowestNum = number;
		    	}
		    	
		    	//keep track of how many number is in list
		    	counter = counter + 1;
		}
		
		//get average of all numbers in file
		average = getAverage(totalSum, counter);
		
		
		//close the file that reading from 
		inputFile.close();
		
		//open file to write to
		String outputFilename = "HW3File.txt";
		FileWriter fwriter = new FileWriter(outputFilename, true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		
		//display the information
		displayInfo( highestNum, lowestNum, average);
		
		//write information to a file
		writeToFile(outputFile, highestNum, lowestNum, average);
		
		//close the file that writing to
		outputFile.close();
	}
	
	//get the average of numbers in the list
	public static double getAverage(double totalSum, double counter) {
		double average = totalSum / counter;
		return average;
	}
	
	//Display the info on console
	public static void displayInfo(double highestNum, double lowestNum, double average){
		System.out.println("Here is some information from your list: ");
		//outputFilename.println("Here is some information from your list: ");
		System.out.printf("Lowest Number: %.0f%n", lowestNum);
		//outputFilename.printf("Lowest Number: %.0f%n", lowestNum );
		System.out.printf("Highest Number: %.0f%n", highestNum);
		//outputFilename.printf("Highest Number: %.0f%n", highestNum);
		System.out.printf("Average: %.2f%n", average);
		//outputFilename.printf("Average: %.2f%n", average);
	}
	
	//write info to file
	public static void writeToFile(PrintWriter outputFile, double highestNum, double lowestNum, double average) throws IOException{
		outputFile.println("Here is some information from your list: ");
		outputFile.printf("Lowest Number: %.0f%n", lowestNum );
		outputFile.printf("Highest Number: %.0f%n", highestNum);
		outputFile.printf("Average: %.2f%n", average);
	}

	
	}

