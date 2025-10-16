package exercise.fundamentals;

import java.util.Locale;
import java.util.Scanner;

public class TimeConverter {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("=== Time Converter ===");
		System.out.println();
		System.out.print("Inform the minutes: ");
		int minutes = sc.nextInt();
		
		
				
        if (minutes % 60 == 0) {
        	
        	int hours =  minutes/60;
        	System.out.printf("Result: " + hours +"hs");	
        }
        else {
        	int hours =  minutes/60;
        	minutes = minutes % 60;
        	System.out.printf("Result: " + hours +" hs" + " and " + minutes + " min");
        }
		

		sc.close();

	}

}
