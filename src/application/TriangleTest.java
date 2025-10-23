package application;

import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Triangle;

public class TriangleTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================");
		System.out.println("=====Triangle=====");
		System.out.println("==================");
		
		System.out.print("Inform the sideA:");
		double sideA = sc.nextDouble();
		System.out.print("Inform the sideB:");
		double sideB = sc.nextDouble();
		System.out.print("Inform the sideC:");
		double sideC = sc.nextDouble();
		
		Triangle triangle = new Triangle(sideA, sideB, sideC);
		
		if (triangle.isValid()) {
			System.out.println();
			System.out.println("=====================================");
			System.out.println("=====The perimeter of a triangle=====");
			System.out.println("=====================================");
			System.out.println(triangle.toString());
			
		}
		else {
			System.out.println();
			System.out.println("The given measurements don't form a triangle!");	
		}
		
		sc.close();

	}

}
