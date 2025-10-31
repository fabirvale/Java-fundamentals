package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Employee;
import exercise.poo.Manager;
import exercise.poo.Seller;

public class EmployeeTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		for(int i=0; i < 3; i++)
		{
			System.out.println("================");
			System.out.println("===Employee " + (i +1) + "===");
			System.out.println("================");
			
			System.out.print("Inform the employee name:");
			String name = sc.nextLine();
			System.out.print("Inform the position(Employee, Manager or Seller):");
			String position = sc.nextLine();
			System.out.print("Inform the gross salary:");
			double grossSalary = sc.nextDouble();
			System.out.print("Inform the discount value (%):");
			double discount = sc.nextDouble();
						
			if (position.equalsIgnoreCase("Manager")) {
				System.out.print("Inform the bonus value:");
				double bonus = sc.nextDouble();
				sc.nextLine(); // clean the buffer
				employees.add(new Manager(name, grossSalary, discount, position, bonus));
			}
			else if (position.equalsIgnoreCase("Seller")) {
				System.out.print("Inform the total sales:");
				double totalSales = sc.nextDouble();
				System.out.print("Inform the percentual commission (%):");
				double commission = sc.nextDouble();
				sc.nextLine(); // clean the buffer
				employees.add(new Seller(name, grossSalary, discount, position, totalSales, commission));
			}
			else if (position.equalsIgnoreCase("Employee"))  {
				 sc.nextLine(); // clean the buffer
				 employees.add(new Employee(name, grossSalary, discount, position));
			}
			else  {
				System.out.println("\"Position not recognized! Skipping this employee!");
				break;
			}
		}	
		System.out.println();
		System.out.println("=========================");
		System.out.println("===== Payroll Report=====");
		System.out.println("==========================");
		System.out.println();
		
	    for(Employee e: employees) {
	    	System.out.println(e +  "\n Net salary $:" + String.format("%.2f", e.calculateNetSalary()));
	    	System.out.println();
	    }
		sc.close();

	}

}
