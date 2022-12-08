import java.util.Scanner; // Needed for the Scanner class
import java.io.*;         // Needed for the File class


public class Program4a {

	public static void main(String[] args) throws IOException {
		
		//declare variables
		int numGrades = 0;
		
		//create array to hold test scores
		int[] scores;
		scores = new int[8];
	
		
		//open file to read from
		String filename = "TestScores.txt";
		File file = new File (filename);
		Scanner inputFile = new Scanner(file);
		
		//variable to keep track of loops, and index for array
		int i = -1;
		
		//read the file
		while (inputFile.hasNext()) {
			int score = inputFile.nextInt();
			//store the first integer from file as the number of grades 
			if (i == -1) {
				numGrades = score;
				i++;
				continue;
			}
			
			//add the test score to the array and increment i
			scores[i] = score;
			i++;
		}
		
		inputFile.close();		
		
		//get the best score and display
		int bestScore = getBestScore(scores);
		System.out.println("Best Score: " + bestScore);
		
		//get the grade for each student and display it
		for (int n = 0; n < scores.length; n++) {
			char studentGrade =  getGrade(bestScore, scores[n]);
			System.out.println("Student " + (n+1) + "'s score is " + scores[n] + " and his grade is " + studentGrade + ".");
		}
			
	}
	
	//get the best score
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
	

}
