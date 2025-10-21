package exercise.controlstructures;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("===========================");
		System.out.println("=== Multiplication table===");
		System.out.println("===========================");

		System.out.print("Inform the number: ");
		int num1 = sc.nextInt();
		System.out.println();

		if (num1 < 0) {
			System.out.println("Please enter a positive number!");
		} else {
			for (int i = 1; i <= 10; i++) {
				System.out.println(num1 + " x " + i + " = " + (num1 * i));
			}
		}
		System.out.println("\nEnd of multiplication table!");
		sc.close();

	}

}
