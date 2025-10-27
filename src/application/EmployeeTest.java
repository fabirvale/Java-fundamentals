package application;

import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==================");
		System.out.println("=====Employee=====");
		System.out.println("==================");
		
		System.out.print("Inform the employee name:");
		String name = sc.nextLine();
		System.out.print("Inform the gross salary:");
		double grossSalary = sc.nextDouble();
		System.out.print("Inform the discount value (%):");
		double discount = sc.nextDouble();
		
		Employee employee = new Employee(name, grossSalary);
		
		double netSalary = employee.calculateNetSalary(discount);
		
		System.out.println();
		System.out.println("=========================");
		System.out.println("=====Employee report=====");
		System.out.println("==========================");
		
	    System.out.println(employee.toString() 
	    		           + "\n Discount (%): " + String.format("%.2f", discount)
	    		           + "\n Discount Value $: " + String.format("%.2f", employee.getValueDiscount())
	    		           + "\n Net salary $: " + String.format("%.2f", netSalary));
		sc.close();

	}

}
