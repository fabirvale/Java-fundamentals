package exercise.fundamentals;

import java.util.Locale;
import java.util.Scanner;

public class CalculateCircle {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("=== Calculate the area of a circle ===");
		System.out.println();
		System.out.print("Inform the radius: ");
		double raio = sc.nextDouble();
		
		double area = (raio * raio) * Math.PI;
		
		System.out.printf("Area of a circle : %.4f\n", area);
		
		sc.close();

	}

}
