package exercise.fundamentals;

import java.util.Locale;
import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("=== Temperature Converter ===");
		System.out.print("Inform the temperature in Celsius:");
		double celsius = sc.nextDouble();

		double fahrenheit = (celsius * 1.8) + 32;
		double kelvin = celsius + 273.15;
		
		System.out.println();
		System.out.printf("Fahrenheit: %.2f °F%n", fahrenheit);
		System.out.printf("Kelvin: %.2f K%n", kelvin);

		sc.close();

	}

}
