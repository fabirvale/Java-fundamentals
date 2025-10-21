package application;

import java.util.Scanner;

import exercise.poo.Person;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=========================");
		System.out.println("=== Introduce yourself===");
		System.out.println("=========================");
		
		System.out.print("Inform the name: ");
		String name = sc.nextLine();
		
		int age;
		
		while (true) {
            System.out.print("Inform the age: ");
            age = sc.nextInt();

            if (age < 0) {
                System.out.println("Age cannot be negative. Please enter a valid age.");
            } else {
                break; 
            }
        }
		
		Person person = new Person(name, age);
		
		System.out.println();
		person.introduce();
	
       sc.close();
	}

}
