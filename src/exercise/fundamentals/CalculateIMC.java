package exercise.fundamentals;

import java.util.Locale;
import java.util.Scanner;

public class CalculateIMC {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("=== Calculate IMC ===");

		System.out.print("Inform the name: ");
		String name = sc.nextLine();

		System.out.print("Inform the gender (M/W): ");
		char gender = sc.next().toUpperCase().charAt(0);
		
		System.out.print("Inform the age: ");
		int age = sc.nextInt();

		System.out.print("Inform the weight (Kg):");
		double weight = sc.nextDouble();

		System.out.print("Inform the height(m):");
		double height = sc.nextDouble();

		double imc = weight / (height * height);

		System.out.println();
		System.out.printf(name + ", seu IMC: é %.2f\n", imc);

		if (age < 18) {
			System.out.println("Classification: Child IMC – consult the OMS.");
		} else {
			if (imc < 18.5) {
				System.out.println("Classification: Underweight.");
			} else if (imc < 25.0) {
				System.out.println("Classification: Normal weight.");
			} else if (imc < 30.0) {
				System.out.println("Classification: Overweight.");
			} else if (imc < 35.0) {
				System.out.println("Classification: Obesity grade I.");
			} else if (imc < 40.0) {
				System.out.println("Classification: Obesity grade II.");
			} else {
				System.out.println("Classification: Obesity grade III (Morbid obesity).");
			}
		}

		sc.close();

	}

}
