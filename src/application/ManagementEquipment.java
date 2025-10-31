package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Equipment;
import exercise.poo.Firewall;
import exercise.poo.Router;
import exercise.poo.Server;
import exercise.poo.Switch;

public class ManagementEquipment {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Equipment> equipments = new ArrayList<>();
        int option;
		
		showMenu();
				
		do {
			
			System.out.print("Choose the option: ");
		    option= sc.nextInt();
		    sc.nextLine();
		    
		    if (option == 8) {
				System.out.println("Exiting the program...");
				break;
			}
		    switch (option) {
			case 1:
				System.out.println();
				System.out.println("--------Register the equipment--------");
				 if (registerEquipment(sc, equipments)) {
					System.out.println("Equipment registered sucessfully!"); 
				 }
				 else {
					 System.out.println("the register is invalid!Try again."); 
				 }
				break;
			case 2:
				System.out.println();
				System.out.println();
				System.out.println("--- List of Equipments ---");
				for(Equipment e: equipments) {
					System.out.println();
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println();
				System.out.println("Turn On / Turn Off / Restart Equipment");
				break;
			case 4:
				System.out.println();
				System.out.println("Calculate Energy Consumption");
				break;
			case 5:
				System.out.println();
				System.out.println("Status Report");
				break;
			case 6:
				System.out.println();
				System.out.println("Search Equipment by IP");
				break;
			case 7:
				System.out.println();
				System.out.println("Remove Equipment by IP");
				break;
						
			default:
				System.out.println("Exiting the program...");
			}
			System.out.println();
            
			 
		} while (option != 8);
		
	    sc.close();
	}
	
	public static void showMenu() {
		
		System.out.println("========================================");
		System.out.println("=======NETWORK MANAGEMENT SYSTEM========");
		System.out.println("========================================");
        System.out.println();
				
		System.out.println("1 - Register Equipment");
		System.out.println("2 - List Equipment");
		System.out.println("3 - Turn On / Turn Off / Restart Equipment");
		System.out.println("4 - Calculate Energy Consumption");
		System.out.println("5 - Status Report");
		System.out.println("6 - Search Equipment by IP");
		System.out.println("7 - Remove Equipment by IP");
		System.out.println("8 - Exit");
		System.out.println();
		
	}
	
	public static boolean registerEquipment(Scanner sc, List<Equipment> equipments) {
		String type;
		
		while (true) {
		    System.out.print("Type (Router / Switch / Server / Firewall): ");
		    type = sc.nextLine().trim();

		    // check if type is valid
		    if (type.equalsIgnoreCase("Router") ||
		        type.equalsIgnoreCase("Switch") ||
		        type.equalsIgnoreCase("Server") ||
		        type.equalsIgnoreCase("Firewall")) {
		        break; // sai do loop — tipo válido
		    } else {
		        System.out.println("Unknown equipment type! Please enter a valid type.");
		    }
		}
		
		System.out.print("Inform the model: ");
		String model = sc.nextLine();
		System.out.print("Inform the IP: ");
		String ip = sc.nextLine();
	
		while (true) {
		    if (!validarIP(ip)) {
		        System.out.println("IP invalid! Try again.");
		        System.out.print("Inform the IP: ");
			    ip = sc.nextLine();
		        continue; // volta para o início do loop
		    }

		    if (ipExist(ip, equipments)) {
		        System.out.println("This IP already was registered! Inform other IP.");
		        System.out.print("Inform the IP: ");
			    ip = sc.nextLine();
		        continue; //return to the beginning of the loop
		    }

		    break; //Exit the loop — IP is valid and unique
		}

		System.out.print("Inform the manufacturer: ");
		String manufacturer = sc.nextLine();
		System.out.print("Inform the state(on/off): ");
		String state = sc.nextLine();
	    System.out.print("Inform the energy consumption(W): ");
	    double energyconsumption = sc.nextDouble();
	    sc.nextLine();
	    
	    if (type.equalsIgnoreCase("Router")){
	    	System.out.print("Support the Wifi(true/false): ");
	    	boolean supportWifi = sc.nextBoolean();
	    	System.out.print("Inform the Mbps: ");
	    	int mbps = sc.nextInt();
	    	equipments.add(new Router(type, model, ip, manufacturer, state, energyconsumption, supportWifi,mbps));
	    	
	    }
	    else if (type.equalsIgnoreCase("Switch")){
	    	System.out.print("Inform the capacity in GB: ");
	    	double portCapacityGB = sc.nextDouble();
	    	equipments.add(new Switch(type, model, ip, manufacturer, state, energyconsumption, portCapacityGB));
	    }
	    else if (type.equalsIgnoreCase("Server")){
	    	System.out.print("Inform the Operating System: ");
	    	String opSystem = sc.nextLine();
	    	System.out.print("Inform the RAM capacity: ");
	    	int ramCapacity = sc.nextInt();
	    	System.out.print("Inform the Disk capacity: ");
	    	int diskCapacity = sc.nextInt();
	    	equipments.add(new Server(type, model, ip, manufacturer, state, energyconsumption, opSystem, ramCapacity, diskCapacity));
	    }
	    else if (type.equalsIgnoreCase("Firewall")) {
	    	System.out.print("Support statefullPacketInspection(true/false): ");
	    	boolean statefullPacketInspection = sc.nextBoolean();
	    	System.out.print("Support blockDoS(true/false): ");
	    	boolean blockDoS = sc.nextBoolean();
	    	equipments.add(new Firewall(type, model, ip, manufacturer, state, energyconsumption, statefullPacketInspection, blockDoS));
	    }
	    else {
	    	return false;
	    }
	       return true;
	}
	
	public static boolean validarIP(String ip) {
	    String regex =
	        "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
	        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
	    return ip.matches(regex);
	}

	public static boolean ipExist(String ip, List<Equipment> equipments) {
	    for (Equipment e : equipments) {
	        if (e.getIp().equals(ip)) {
	            return true; // there is IP in list
	        }
	    }
	    return false; // there is no IP in list
	}

}
