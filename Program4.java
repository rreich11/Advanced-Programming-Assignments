import java.util.Scanner; // Needed for the Scanner class
import java.io.*;         // Needed for the File class

public class Program4 {

	public static void main(String[] args) throws IOException {

		//open file to read from
		String filename = "TestScoresWithNames.txt";
		File file = new File (filename);
		Scanner inputFile = new Scanner(file);
		//declare variables
		int numGrades = inputFile.nextInt();

		//create array to hold test scores
		int[] scores = new int [numGrades];
		String[] studentNames = new String[numGrades];

		//variable to keep track of loops, and index for array
		int i = 0;

		//read the file
		while (inputFile.hasNext()) {
			int score = inputFile.nextInt();
			//add the test score to scores array 
			scores[i] = score;

			//clear buffer
			inputFile.nextLine();

			//add the name to studentNames array
			String name = inputFile.nextLine();
			studentNames[i] = name;
			/*inputFile.nextLine();*/

			//increment i
			i++;
		}//close while

		//close file
		inputFile.close();	

		//get the best score and display
		int bestScore = getBestScore(scores);
		System.out.println("Best Score: " + bestScore);
		System.out.println(); 

		//get the grade for each student and display it
		for (int n = 0; n < scores.length; n++) {
			char studentGrade =  getGrade(bestScore, scores[n]);
			System.out.println(studentNames[n] + "'s score is " + scores[n] + " and his grade is " + studentGrade + ".");
		}	
		//display students and corresponding grades
		displayNameAndScore(studentNames, scores);

		//get and display grades test score average
		double average = getScoreAverage(scores);
		System.out.println();
		System.out.printf("Average Score for Class: %.2f%n ", average);

		//get and display number of tests above average
		int testsAboveAverage = getNumTestsAboveAverage(scores, average);
		System.out.println();
		System.out.println("Number of Scores Greater than or Equal to Average: " + testsAboveAverage);

		//get and display number of tests above average
		int testsBelowAverage = getNumTestsBelowAverage(scores, average);
		System.out.println();
		System.out.println("Number of Scores Below Average: " + testsBelowAverage);

	}//close main


	/**
    The getBestScore method returns the best score from the array
     that was passed to it.
    @param scores The array that holds scores, method will look for best score 
     in this array.
    @return The best score from array.
	 */

	public static int getBestScore(int[] scores) {
		int bestScore = 0;

		//if the score in array is greater than best score, then bestScore is equal to that score
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > bestScore) {
				bestScore = scores[i];
			}	
		}
		return bestScore;
	}

	/**
    The getGrade method returns the sum Grade that is calculted from the students 
     score.
    @param bestScore The highest score from the list.
    @param score The element from the scores array, its the students score.
    @return The grade of the student.
	 */
 
	public static char getGrade(int bestScore, int score) {
		//initialize variable to hold the grade
		char grade;
		//Calculate the grade and return
		if (score >= bestScore - 10) {
			grade = 'A';
			return grade;
		} 
		else if(score >= bestScore - 20) {
			grade = 'B';
			return grade;
		}
		else if (score >= bestScore - 30) {
			grade = 'C';
			return grade;
		}
		else if (score >= bestScore - 40) {
			grade = 'D';
			return grade;
		}
		else {
			grade = 'F';
			return grade;
		}
	}

	/**
    The displayNameAndScore method displays the student names and score.
    @param StudentNames The array holding the students' names.
    @param scores The array with the students scores.
	 */
 
	public static void displayNameAndScore(String[] studentNames, int[] scores ) {
		System.out.println();
		for (int n=0; n < scores.length; n++) {
			System.out.printf("Name: %s, Score: %s%n", studentNames[n], scores[n]);
		}
	}

	/**
    The getScoreAverage method returns the average of the all the scores.
    @param scores The array holding the scores.
    @return The average of the scores.
	 */
	
	public static double getScoreAverage(int[] scores){
		double total = 0;
		double counter = 0;
		//add each grade for array scores array to total
		for  (int i = 0; i < scores.length; i++) {
			double score = scores[i];
			total += score;

			//increment counter
			counter++;
		}
		//calculate the average 
		double average = total / counter;
		return average;	
	}

	/**
    The getNumTestsAboveAverage method returns the sum of its two parameters.
    @param scores The array holing the scores.
    @param average The average of all the scores.
    @return The number of scores equal to or above average.
	 */

	public static int getNumTestsAboveAverage(int[] scores, double average) {
		//variable to hold number of scores greater/equal to average
		int aboveAverage = 0;

		//for each score if greater than or equal to average, increment aboveAverage variable
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= average) {
				aboveAverage++;
			}
		}
		return aboveAverage;
	}

	/**
    The getNumTestsBelowAverage method returns the sum of its two parameters.
    @param scores The array holing the scores.
    @param average The average of all the scores.
    @return The number of scores below average.
	 */
	public static int getNumTestsBelowAverage(int[] scores, double average) {
		//variable to hold number of scores below to average
		int belowAverage = 0;

		//for each score if greater than or equal to average, increment aboveAverage variable
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < average) {
				belowAverage++;
			}
		}
		return belowAverage;
	}

}//close class