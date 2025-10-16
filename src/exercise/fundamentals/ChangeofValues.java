package exercise.fundamentals;

import java.util.Scanner;

public class ChangeofValues {
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== Change of Values ===");
		System.out.print("Enter with the first value:");
		int num1 = sc.nextInt();
		
		System.out.print("Enter with the second value:");
		int num2 = sc.nextInt();
		
		System.out.println();
		System.out.println("Before the exchange");
		System.out.println("A=" + num1 + ", B=" + num2);
		
		num2 = num2 + num1;
		System.out.println();
	    System.out.println("After the exchange");
	    System.out.println("A=" + (num2 -num1) + ", B=" + num1);
		
		sc.close();
		
	}
	

}
