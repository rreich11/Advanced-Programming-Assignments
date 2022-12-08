import java.util.Scanner; // Needed for the Scanner class

public class Program6 {

	public static void main(String[] args) {
		
		//create scanner object
		Scanner keyboard = new Scanner(System.in);
	
		//method to create the array
		int[][] magicSquare = create2DArray(keyboard);
		
		//display whether or not it's a magic square
		boolean isASquare = isSquare(magicSquare, keyboard);
		if (isASquare) {
			System.out.println("Congragulations! You've created a Lo Shu magic square!");
		}
		else {
			System.out.println("Sorry, this is not a Lo Shu Magic Square.");
		}
	} 
	
	public static int[][] create2DArray(Scanner keyboard) {
		
		System.out.println("Enter the numbers 1-9, so that when displayed in a 3 by 3 grid, " + 
				" the sum of each row, each column , and each diagonal all add up to the same number. "	);
		
		//define 2d array
		int[][] magicSquare = new int[3][3];
		for (int row = 0; row < magicSquare.length; row++) {
			for (int col = 0; col < magicSquare[row].length; col++) {
				//let user fill the array
				System.out.print("Number: ");
				magicSquare[row][col] = keyboard.nextInt();
				//validate to see if number is between 1 and 9
				boolean isNum1To9 = false; 		
				while (!isNum1To9) {
					isNum1To9 = num1to9(magicSquare[row][col]);    //call method to see if number is between 1 and 9
					if(!isNum1To9) {                               //if number is invalid, get user to reenter
						System.out.print("Please reenter a number between 1 and 9, that has not yet been entered: ");
						magicSquare[row][col] = keyboard.nextInt();
					}
				}
				
				
			}
		}
		
			return magicSquare;
	} //close create2DArray method
	
	
	public static boolean isSquare(int[][] magicSquare, Scanner keyboard) {
		
		//validate that number entered has not yet been entered
		boolean numberExists = false;
		
		for (int i = 0; i < magicSquare.length; i++) {           //for each value call the method that checks to see if the value is already in the array
			for (int j = 0; j < magicSquare[i].length; j++) {
				numberExists = checkDuplicates(magicSquare, magicSquare[i][j]);
			}
				if (numberExists) {                                   //if the number does exist, numberExists becomes true, and the loop ends
					break;
				}
			}
		
		//display msg if number exists
		if (numberExists) {
			System.out.println("You entered more than one number with the same value");
		}
				
		
		//validate all 3 rows = 15
		boolean rowsEquals15 = false;                                 //variable to see if the sum of each row is 15
		//pass the subscript of row for each as the second parameter
		boolean firstRowEqual = rowEquals15(magicSquare, 0);   //first row equals 15?
		boolean secondRowEqual = rowEquals15(magicSquare, 1);  //second row equals 15?
		boolean thirdRowEqual = rowEquals15(magicSquare, 2);   //third row equals 15?
		                                                       
		if (firstRowEqual && secondRowEqual && thirdRowEqual) { //determine if the sum of all three rows equals 15
			 rowsEquals15 = true;                  
		}
		
		if (!rowsEquals15) {
			System.out.println("One or more rows don't equal 15");
		}
		
		//validate all 3 columns = 15
		boolean colsEquals15 = false;                                 //variable to see if the sums of each row is 15
        //pass the subscript of row for each as the second parameter
		boolean firstColEqual = colEquals15(magicSquare, 0);   //first row equals 15?
		boolean secondColEqual = colEquals15(magicSquare, 1);  //second row equals 15?
		boolean thirdColEqual = colEquals15(magicSquare, 2);   //third row equals 15?
                                               
		if (firstColEqual && secondColEqual && thirdColEqual) { //determine if the sum of all three rows equals 15
			colsEquals15 = true;                  
		}
		
		if (!colsEquals15) {
			System.out.println("One or more columns don't equal 15");
		}
		
		
			
			//validate 2 diagonals = 15
			boolean diagsEquals15 = false;                                  //variable to see if the sums of each diagonal is 15
			//pass the subscripts for each of the diagonals
			boolean firstDiag = diagEquals15(magicSquare, 0,1,2,0,1,2);    //first diag equals 15?
			boolean secondDiag = diagEquals15(magicSquare, 0,1,2,2,1,0);   //first diag equals 15?
			
			if (firstDiag && secondDiag) {                                 //determine if the sum of both diagonals equals 15
				diagsEquals15 = true;
			}
			
			if (!diagsEquals15) {
				System.out.println("One or more diagonals don't equal 15");
			}
			
			
			//check to see if it's a square:  no numbers are repeated, consists of numbers 1-9, and
			//diagonals, rows and columns are equal to 15 
			if (!numberExists && rowsEquals15 && colsEquals15 && diagsEquals15) {
				return true;
			}
			else {
				return false;
			}
	
	}//close isSquare method
	
	public static boolean num1to9(int value) {
		boolean isNum1to9 = true;
				if (value < 1 || value > 9) {
					isNum1to9 = false;
					return isNum1to9;
				    }
			return isNum1to9;
		}
	
	public static boolean checkDuplicates(int[][] magicSquare, int value) {
		int exists = 0;
		for (int i = 0; i < magicSquare.length; i++) {
			for (int j = 0; j < magicSquare[i].length; j++) {
				if (magicSquare[i][j] == value) {
					exists++;
				}
			}
		}
		if (exists > 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public static boolean rowEquals15(int[][] magicSquare, int row) {
		if (magicSquare[row][0] + magicSquare[row][1] + magicSquare[row][2] == 15) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean colEquals15(int[][] magicSquare, int col) {
		if (magicSquare[0][col] + magicSquare[1][col] + magicSquare[2][col] == 15) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean diagEquals15(int[][] magicSquare, int row0, int row1, int row2, int col0, int col1, int col2) {
		if(magicSquare[row0][col0] + magicSquare[row1][col1] + magicSquare[row2][col2] == 15) {
			return true;
		}
		else {
			return false;
		}
	}

	
	
	
}//close class
