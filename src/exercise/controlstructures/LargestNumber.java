package exercise.controlstructures;

import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		

		System.out.println("=== Checking the largest number ===");
		System.out.println();
		System.out.print("Inform the first number: ");
		int num1 = sc.nextInt();
		System.out.print("Inform the second number: ");
		int num2 = sc.nextInt();
		System.out.print("Inform the third number: ");
		int num3 = sc.nextInt();
		
		int largest = num1;
        if (num2 > largest) {
			
			largest = num2;
		}
	   
        if (num3 > largest) {
			
			largest = num3;
		}   

		System.out.println();
		System.out.println("The largest number is: " + largest);
		
		if ((num1 == num2 && num1 == largest) || (num1 == num3 && num1 == largest) || (num2 == num3 && num2 == largest)) {
	            System.out.println("There are equal largest numbers.");
	        }
	    
		sc.close();

	}
}
