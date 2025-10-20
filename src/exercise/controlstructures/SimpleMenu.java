package exercise.controlstructures;

import java.util.Scanner;

public class SimpleMenu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int option;

		do {
			System.out.println("=== MENU ===");
			System.out.println();
			System.out.println("1 - Addition");
			System.out.println("2 - Subtraction");
			System.out.println("3 - Exit");

			System.out.print("Inform the option:");
		    option = sc.nextInt();

			if (option == 3) {
				System.out.println("Exiting the program...");
				break;
			}
            
			System.out.print("Inform the first number:");
			int number1 = sc.nextInt();
			System.out.print("Inform the second number:");
			int number2 = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println();
				System.out.println("Addition result: " + (number1 + number2));
				break;
			case 2:
				System.out.println();
				System.out.println("Subtraction result: " + (number1 - number2));
				break;
			default:
				System.out.println("the option is invalid!");
			}
			System.out.println();
		} while (option != 3);
		sc.close();
	}

}
