package exercise.controlstructures;

import java.util.Scanner;

public class AgeRating {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== Age rating ===");
		System.out.println();
		System.out.print("Inform the age: ");
		int age = sc.nextInt();
		
		System.out.println();
		if ( age < 0) {
			System.out.println("the age is invalid.");
		}
		else if (age <= 11) {
			System.out.println("Classification: Children.");
		}	
		else if (age <= 17) {
			System.out.println("Classification: Teenager.");
		}
		else if (age <=59) {
			System.out.println("Classification: Adult");
		}
		else {
			System.out.println("Classification: Elderly");
		}
		
		
		
		sc.close();
	}

}
