package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exercise.poo.Animal;
import exercise.poo.Bird;
import exercise.poo.Cat;
import exercise.poo.Dog;

public class AnimalTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Animal> animals = new ArrayList<>();	

		for (int i=0; i < 3; i++) {
			
			System.out.println("================");
			System.out.println("====Animal " + (i +1) + "===");
			System.out.println("================");
	
			System.out.print("Enter the animal's name: ");
			String name = sc.nextLine();
			System.out.print("Enter the animal's age: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the animal type (dog, cat, bird): ");
			String type = sc.nextLine();
			
			if (type.equalsIgnoreCase("dog")) {
				System.out.print("Enter the animal's breed: ");
				String breed = sc.nextLine();	
				animals.add(new Dog(name, age, type, breed));
			}
			else if (type.equalsIgnoreCase("cat")) {
				System.out.print("Enter the animal's eyecolor: ");
				String eyecolor = sc.nextLine();
				animals.add(new Cat(name, age, type, eyecolor));
			}
			else if (type.equalsIgnoreCase("bird")) {
				System.out.print("Does it know to sing (true/false)? ");
				boolean knowsHowToSing = sc.nextBoolean();
				animals.add(new Bird(name, age, type, knowsHowToSing));
			}
			else {
			    System.out.println("Unknown animal type! Skipping...");
			    continue;
			}
			
		    System.out.println();
	}	  
		System.out.println("===================");
		System.out.println("===Animal Sounds===");
		System.out.println("===================");
	
		for(Animal a:animals) {
			 System.out.println(a);
			 System.out.println();
		}

		sc.close();

	}

}
