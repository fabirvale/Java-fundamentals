package application;

import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Product;

public class ProductTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=================");
		System.out.println("=====Product=====");
		System.out.println("=================");
		
		System.out.print("Inform the name: ");
		String name = sc.nextLine();
		System.out.print("Inform the price: ");
		double price = sc.nextDouble();
		System.out.print("Inform the quantity: ");
		int quantity = sc.nextInt();
		
		Product product = new Product(name, price, quantity);
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println("=====Total value the products in stock=====");
		System.out.println("===========================================");
		
		System.out.println(product.toString());
		
		sc.close();
	}

}
