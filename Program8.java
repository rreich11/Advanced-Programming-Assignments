import java.util.Scanner;

public class Program8 {

	public static void main(String[] args) {
		
		//create a scanner object
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the radius of circle 1: ");
		double radius = keyboard.nextInt();
		
		//Creating Circle object using constructor that accepts a radius as an argument
		Circle circle1 = new Circle(radius);
		//Creating Circle object using the no arg constructor
		Circle circle2 = new Circle();
		
		
		
		calcCircle1(circle1);
		calcCircle2(keyboard, circle2);
		
		keyboard.close();
		
	}
	
	//calculate and display radius, area, diameter and circumference for circle 1.
		public static void calcCircle1(Circle circle1) {
			System.out.println();
			System.out.println("Properties for circle 1: ");
			System.out.printf("Radius: %,.2f\n", circle1.getRadius());
			System.out.printf("Area: %,.2f\n", circle1.calcAarea());
			System.out.printf("Diameter: %,.2f\n", circle1.calcDiameter());
			System.out.printf("Circumference: %,.2f\n", circle1.calcCircumference());
		}
		
	//calculate and display radius, area, diameter and circumference for circle 2.	
		public static void calcCircle2(Scanner keyboard, Circle circle2) {
			
			System.out.println();
			
			//set a new radius for circle2 using the setRadius method
			System.out.print("Enter a new radius for circle 2: ");
			double newRadius = keyboard.nextInt();
			circle2.setRadius(newRadius);
		
			System.out.println("Properties for circle 2: ");
			System.out.printf("Radius: %,.2f\n", circle2.getRadius());
			System.out.printf("Area: %,.2f\n", circle2.calcAarea());
			System.out.printf("Diameter: %,.2f\n", circle2.calcDiameter());
			System.out.printf("Circumference: %,.2f\n", circle2.calcCircumference());
		}
	
	
	

}
