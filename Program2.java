import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a Scanner object to read input.
	      Scanner keyboard = new Scanner(System.in);	      
	      
	    //get the account number  
	      String accountNum = getAcntNum(keyboard);
	      
	    //get the account type
	      char accountType = getTypeService(keyboard);
	      
	    //initialize number of minutes  
	      double numMinutes;
	      double numMinutesDay;
	      double numMinutesNight;
	      
	    //switch statement depending on plan
	      switch (accountType) {
	      case 'R':
	    	//get the number of minutes of service used
	    	  numMinutes = getNumMinutesRegBill(keyboard);
	    	  
	    	//get the price for regular service
		      double priceRegService = calcRegularBill(keyboard, numMinutes);
		      
		    //display the information
		      displayInfo(accountNum, accountType, numMinutes, priceRegService);
		      break;
		      
		  default:
			//get the number of minutes of service used
			  numMinutesDay = getNumMinutesPremBillDay(keyboard);
			  
	    	  numMinutesNight = getNumMinutesPremBillNight(keyboard);
	    	  
	    	  numMinutes = numMinutesDay + numMinutesNight;
	    	  
	    	//get the price for premium service
	    	  double pricePremService = calcPremiumBill(numMinutesDay, numMinutesNight);
	    	  
	    	//display the information
	    	  displayInfo(accountNum, accountType, numMinutes, pricePremService);	    	  	    	  		      	    	 
	      }	      
	}
	

	public static String getAcntNum(Scanner keyboard) {
		//declare variable for account number
		String accntNum;
		
		//get the account number and return it to main
		System.out.println("Enter the account number for your account: ");
		accntNum = keyboard.nextLine();
		return accntNum;
	}

	
	public static char getTypeService(Scanner keyboard) {
		//declare variable for account type
		char accnttype;
		
		//get account type
		System.out.println("Enter your account type. 'R' for for regular, and 'P' for premium: ");
		accnttype = keyboard.nextLine().toUpperCase().charAt(0);
		
		//validate users input
		while (accnttype != 'R' && accnttype != 'P') {
			System.out.println("INVALID. Your entry must be a 'R' or a 'P,' please retry to enter your service type: ");
			accnttype = keyboard.nextLine().toUpperCase().charAt(0);
		}
		
		//return account type
		return accnttype;
	}
	
	
	public static double getNumMinutesRegBill(Scanner keyboard){
		//declare variable for number of minutes service was used
		double numMin;
		
		System.out.println("Enter the number of minutes the service was used: ");
		numMin = keyboard.nextInt();
		
		//validate
		while (numMin < 1) {
			System.out.println("Invalid, you must enter a number greater than zero. Please reenter: ");
			numMin = keyboard.nextInt();
		}
		
		//return number of minutes
		return numMin;
	}
	
	
	public static double getNumMinutesPremBillDay(Scanner keyboard) {
		//Get the number of minutes used during the day
				System.out.println("Enter the number of minutes the service was used from 6:00" +
			           " a.m. to 6:00 p.m.: ");
				double minDay = keyboard.nextDouble();
				
				//validate input for minDay
				while(minDay < 0) {
					System.out.println("Invalid input. You cannot enter a number less than zero. Please reenter the number of minutes used");
					minDay = keyboard.nextDouble();
				}
				
				return minDay;
	}
	
	
	public static double getNumMinutesPremBillNight(Scanner keyboard) {
				//Get the number of minutes used at night
				System.out.println("Enter the number of minutes the service was used from 6:00" +
				       " p.m. to 6:00 a.m.: ");
				double minNight = keyboard.nextDouble();
				
				//validate input for minNight
				while(minNight < 0) {
					System.out.println("Invalid input. You cannot enter a number less than zero. Please reenter the number of minutes used");
					minNight = keyboard.nextDouble();
				}
				
				return minNight;
	}
	
	
	public static double calcRegularBill(Scanner keyboard, double numMinutes){
		
		//first 50 minutes free
		double freeMinutes = 50;
		
		//subtract 50 from minutes used
		double chargedMinutes = numMinutes - freeMinutes;
		
		//initial price of 10 dollars, plus each additional minute after 50 is charged 20 cents
		double finalCostRegService = 10.00 + (chargedMinutes * .2);
		
		//return final cost of plan
		return finalCostRegService;
	}
	
	
	public static double calcPremiumBill(double minDay, double minNight ) {

		//first 75 minutes during day are free
		double freeMinutesDay = 75;
		
		//subtract free minutes from total minutes used by day
		double chargedMinutesDay = minDay - freeMinutesDay;
		
		// during day each additional minute after 75 is 10 cents
		double finalCostDay = chargedMinutesDay * .1;
		
		//first 100 minutes at night are free
		double freeMinutesNight = 100;
		
		//subtract free minutes from total minutes used at night
		double chargedMinutesNight = minNight - freeMinutesNight;
		
		//at night each additional minute after 100 is 5 cents
		double finalCostNight = chargedMinutesNight * .05;
		
		//initial cost of 25 dollars plus the combined cost of day and night for final plan cost
		double finalCostPremiumService = 25.00 + finalCostDay + finalCostNight;
		
		//return final cost to main
		return finalCostPremiumService;	
	}
	
	public static void displayInfo(String accountNum, char accountType, double numMinutes, double priceService) {
		System.out.println("Here is your account information");
		System.out.printf("Account Number: %s\n", accountNum);
		System.out.printf("Type of Service: %c\n", accountType);
		System.out.printf("Number of Minutes Service Used: %.2f\n",   numMinutes);
		if (accountType == 'R') {
			System.out.printf("Amount Due: $%.2f\n",  priceService);}
			else {
				System.out.printf("Amount Due: $%.2f\n", priceService);
			}
	}
	
	
}
