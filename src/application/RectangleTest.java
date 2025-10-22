package application;

import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Rectangle;

public class RectangleTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=================");
		System.out.println("====Rectangle====");
		System.out.println("=================");
		
		System.out.print("Inform the width: ");
		Double width = sc.nextDouble();
		System.out.print("Inform the height: ");
		Double height = sc.nextDouble();
		
		Rectangle rectangle = new Rectangle(width, height);
		
		System.out.println();		
		System.out.println("==========================");
		System.out.println("====Rectangle Measures====");
		System.out.println("==========================");
		
		System.out.println(rectangle.toString());
		
		sc.close();

	}

}
