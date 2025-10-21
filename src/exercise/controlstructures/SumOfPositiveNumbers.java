package exercise.controlstructures;

import java.util.Scanner;

public class SumOfPositiveNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int number;

		System.out.println("==============================");
		System.out.println("=== Sum of positive numbers===");
		System.out.println("==============================");

		do {
			System.out.print("Inform the number: ");
			number = sc.nextInt();
			if (number < 0) {
				break;
			} else {
				sum += number;
			}
		} while (true);
		
		System.out.println();
		System.out.println("Sum of positive numbers is: " + sum);

		sc.close();

	}

}
