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
				clearScreen();
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
				clearScreen();
				listEquipments(equipments);
			    break;	
			case 3:
				   clearScreen();
				   if (equipments.isEmpty()) {
						System.out.println("No equipment registered yet.");
					}
				   else {
	                      while (true)
	                      {
					          System.out.print("Which of the operations would you like to execute (Turn On / Turn Off / Restart)?");
					          String op = sc.nextLine().trim();
	                           
					          // check if operation is valid
	    	                 if (op.equalsIgnoreCase("Turn On") || 
	    	                	 op.equalsIgnoreCase("Turn Off") || 
	    	                	 op.equalsIgnoreCase("Restart"))
	                         {
					             System.out.print("Inform the IP:");
	                             String ip = sc.nextLine();
	                             if (!validarIP(ip)) {
				                     System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
				                     continue; //go back to the beginning of the loop
			                      }
	                              else{
	                                  executeOperation(op, ip, equipments);
	                                  break;
	                               }
	                         }   
	                          else 
	                          {
	    		                 System.out.println("Unknown the operation! Please enter a valid type.");
	                             continue;
	    	                  }
	                    }
					}  

             	break;
			case 4:
				clearScreen();
				System.out.println();
				if (equipments.isEmpty()) {
				    System.out.println("No equipment registered yet.");
				 }
				else {
					  boolean found = false;
				      while (true)
				       {  
				    	  System.out.println("================================== ENERGY REPORT ===================================");
				    	  System.out.print("Inform the IP:");
					      String ip = sc.nextLine();
					      if (!validarIP(ip)) {
					        System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
					        continue; //go back to the beginning of the loop
					       }
					       else{
					    	     
					    	      for (Equipment e : equipments) {
					    		    if (e.getIp().equals(ip)) {
					    			  found = true;
					    			      System.out.println();
					    			 	  System.out.println(e.toString()
								    	   + "\n Consumption/Day: " + e.calculateConsumption(e.getQtdHourConsumption()));
								      }
					    		    System.out.println("=======================================================================================");
					    	   }
					     }
					     break;
				      }  
				      if (!found) {
				    	System.out.println("There is no IP in the list");
				        System.out.println("=====================================================================================");
				      } 
				}               
				break;
			case 5:
				clearScreen();
				if (equipments.isEmpty()) {
				    System.out.println("No equipment registered yet.");
				 }
				else {
					  boolean found = false;
				      while (true)
				       {  
				    	  System.out.println("================================== State REPORT ===================================");
				    	  System.out.print("Inform the IP:");
					      String ip = sc.nextLine();
					      if (!validarIP(ip)) {
					        System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
					        continue; // go back to the beginning of the loop
					       }
					       else{
					     	      for (Equipment e : equipments) {
					    		    if (e.getIp().equals(ip)) {
					    			  found = true;
					    			      System.out.println();
					    			 	  System.out.println(" Model: " + e.getModel()
					    							+ "\n IP: " + e.getIp()
					    							+ "\n Manufacturer: " + e.getManufacturer()
					    							+ "\n State: " + e.getState());
								    }
					    		    System.out.println("=======================================================================================");
					    	   }
					     }
					     break;
				      }  
				      if (!found) {
				    	System.out.println("There is no IP in the list");
				        System.out.println("=====================================================================================");
				      } 
				}               
				break;
			case 6:
				clearScreen();
				if (equipments.isEmpty()) {
				    System.out.println("No equipment registered yet.");
				 }
				else {
					  boolean found = false;
				      while (true)
				       {  
				    	  System.out.println("================================== Search Equipment by IP ===================================");
				    	  System.out.print("Inform the IP:");
					      String ip = sc.nextLine();
					      if (!validarIP(ip)) {
					        System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
					        continue; // go back to the beginning of the loop
					       }
					       else{
					     	      for (Equipment e : equipments) {
					    		    if (e.getIp().equals(ip)) {
					    			  found = true;
					    			  System.out.println();
					    			  System.out.println(e.toString());   
								    }
					    		    System.out.println("=======================================================================================");
					    	   }
					     }
					     break;
				      }  
				      if (!found) {
				    	System.out.println("There is no IP in the list");
				        System.out.println("=====================================================================================");
				      } 
				}               
				break;
			case 7:
				clearScreen();
				if (equipments.isEmpty()) {
				    System.out.println("No equipment registered yet.");
				 }
				else {
					 
				      while (true)
				       {  
						 System.out.println("================================== Remove Equipment by IP ===================================");
				    	  System.out.print("Inform the IP:");
					      String ip = sc.nextLine();
					      if (!validarIP(ip)) {
					        System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
					        continue; // go back to the beginning of the loop
					       }
					       else{
					    	   removeEquipmentByIP(equipments, ip); 
					        }
		 		       break;
				    } 
				}  
	    break;
			default:
				System.out.println("Exiting the program...");
			}
   
		} while (option != 8);
		
	    sc.close();
	}

	public static void showMenu() {
		//clearScreen(); // clean the screean
		System.out.println("========================================");
		System.out.println("=======NETWORK MANAGEMENT SYSTEM========");
		System.out.println("========================================");
		System.out.println();

		System.out.println("1 - Register Equipment");
		System.out.println("2 - List Equipment");
		System.out.println("3 - Turn On / Turn Off / Restart Equipment");
		System.out.println("4 - Calculate Energy Consumption");
		System.out.println("5 - State Report");
		System.out.println("6 - Search Equipment by IP");
		System.out.println("7 - Remove Equipment by IP");
		System.out.println("8 - Exit");
		System.out.println();

	}

	public static boolean registerEquipment(Scanner sc, List<Equipment> equipments) {
		String type, ip, model, manufacturer, state;
		double energyConsumption;
		int qtdHourConsumption;
		while (true) {
			System.out.print("Type (Router / Switch / Server / Firewall): ");
			type = sc.nextLine().trim();

			// check if type is valid
			if (type.equalsIgnoreCase("Router") || type.equalsIgnoreCase("Switch") || type.equalsIgnoreCase("Server")
					|| type.equalsIgnoreCase("Firewall")) {
				break; // sai do loop — tipo válido
			} else {
				System.out.println("Unknown equipment type! Please enter a valid operation.");
			}
		}

		while (true) {
			System.out.print("Inform the model: ");
			model = sc.nextLine().trim();
			if (!model.isEmpty())
				break;
			System.out.println("Model cannot be empty!");
		}

		while (true) {
			System.out.print("Inform the IP: ");
			ip = sc.nextLine();

			if (!validarIP(ip)) {
				System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
				continue; // volta para o início do loop
			}

			if (ipExist(ip, equipments)) {
				System.out.println("This IP already was registered! Inform other IP.");
				continue; // return to the beginning of the loop
			}

			break; // Exit the loop — IP is valid and unique
		}

		while (true) {
			System.out.print("Manufacturer: ");
			manufacturer = sc.nextLine().trim();
			if (!manufacturer.isEmpty())
				break;
			System.out.println("Manufacturer cannot be empty!");
		}

		while (true) {
			System.out.print("State (on/off): ");
			state = sc.nextLine().trim().toLowerCase();
			if (state.equals("on") || state.equals("off"))
				break;
			System.out.println("Invalid state! Must be 'on' or 'off'.");
		}

		// energyConsumption — positive number
		while (true) {
			try {
				System.out.print("Energy Consumption (W): ");
				energyConsumption = Double.parseDouble(sc.nextLine());
				if (energyConsumption > 0)
					break;
				System.out.println("Energy consumption must be positive!");
			} catch (NumberFormatException e) {
				System.out.println("Invalid number! Try again.");
			}
		}
		
		// energyConsumption — positive number
				while (true) {
					try {
						System.out.print("Consumption/Day : ");
						qtdHourConsumption = Integer.parseInt(sc.nextLine());
						if (qtdHourConsumption > 0)
							break;
						System.out.println("Consumption/Day must be positive!");
					} catch (NumberFormatException e) {
						System.out.println("Invalid number! Try again.");
					}
				}

		if (type.equalsIgnoreCase("Router")) {
			System.out.print("Support the Wifi(true/false): ");
			boolean supportWifi = sc.nextBoolean();
			sc.nextLine(); // <- clean the buffer
			int mbps = readPositiveInt(sc, "Inform the Mbps: ");
			;
			equipments.add(new Router(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, supportWifi, mbps));

		} else if (type.equalsIgnoreCase("Switch")) {
			double portCapacityGB = readPositiveDouble(sc, "Inform the Switch Capacity (Gbps): ");
			equipments.add(new Switch(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, portCapacityGB));
		} else if (type.equalsIgnoreCase("Server")) {
			System.out.print("Inform the Operating System: ");
			String opSystem = sc.nextLine();

			int ramCapacity = readPositiveInt(sc, "Inform the RAM Capacity (GB): ");
			int diskCapacity = readPositiveInt(sc, "Inform the Disk Capacity (GB): ");
			equipments.add(new Server(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, opSystem, ramCapacity,
					diskCapacity));
		} else if (type.equalsIgnoreCase("Firewall")) {
			System.out.print("Support statefullPacketInspection(true/false): ");
			boolean statefullPacketInspection = Boolean.parseBoolean(sc.nextLine());
			System.out.print("Support blockDoS(true/false): ");
			boolean blockDoS = Boolean.parseBoolean(sc.nextLine());
			equipments.add(new Firewall(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption,
					statefullPacketInspection, blockDoS));
		} else {
			return false;
		}
		return true;
	}

	public static boolean validarIP(String ip) {
		String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
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

	// Read a positive integer
	public static int readPositiveInt(Scanner sc, String message) {
		while (true) {
			try {
				System.out.print(message);
				int value = Integer.parseInt(sc.nextLine());
				if (value > 0)
					return value;
				System.out.println("Must be positive!");
			} catch (NumberFormatException e) {
				System.out.println("Invalid number!");
			}
		}
	}

	// Lê um número decimal positivo
	public static double readPositiveDouble(Scanner sc, String message) {
		while (true) {
			try {
				System.out.print(message);
				double value = Double.parseDouble(sc.nextLine());
				if (value > 0)
					return value;
				System.out.println("Must be positive!");
			} catch (NumberFormatException e) {
				System.out.println("Invalid number!");
			}
		}
	}

	public static void listEquipments(List<Equipment> equipments) {
		System.out.println();
		System.out.println(
				"===========================================EQUIPMENTS LIST========================================================");
		System.out.println();
		if (equipments.isEmpty()) {
			System.out.println("No equipment registered yet.");
		} else {
			// Cabeçalho da tabela
			System.out.printf("%-10s %-12s %-16s %-15s %-10s %-15s %-15s %-40s%n", "Type", "Model", "IP", "Manufacturer",
					"State", "Energy(W)", "Consumption/Day(KWh)","Specific Info");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------");

			// lines of table
			for (Equipment e : equipments) {
				// Exibe uma linha formatada
				System.out.printf("%-10s %-12s %-16s %-15s %-10s %-15.2f %15s %-40s%n", e.getType(), e.getModel(), e.getIp(),
						e.getManufacturer(), e.getState(), e.getEnergyConsumption(), e.getQtdHourConsumption(), e.getDetails());
			}
		}

		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
	}

	public static void executeOperation(String op, String ip, List<Equipment> equipments) {
		    boolean found = false;
			for (Equipment e : equipments) {
					if (e.getIp().equals(ip)) {
						
                        found = true; //found the ip
						if (op.equalsIgnoreCase("Turn on")) {
							
							if (e.getState().equalsIgnoreCase("on")) {
								System.out.println("The equipment has already been turned on");
							}
							else {
							  e.setState("on");	
							  e.powerOn();
							} 
						} else if (op.equalsIgnoreCase("Turn off")) {
							if (e.getState().equalsIgnoreCase("off")) {
								System.out.println("The equipment has already been turned off");	
							}
							else {
							  e.setState("off");		
							  e.powerOff();
							}
						} else {
							if (e.getState().equalsIgnoreCase("off")) {
		                        System.out.println("The equipment is off! Turn it on before restarting.");
		                    } else {
		                        e.restart();
		                    }
						}
      			   }
		  }
			 if (!found) {
			        System.out.println("No equipment found with IP " + ip);
			    }	
	}
	
	public static void removeEquipmentByIP(List<Equipment> equipments, String ip) {
	    boolean found = false;

	    // percorre a lista de trás para frente
	    for (int i = equipments.size() - 1; i >= 0; i--) {
	        Equipment e = equipments.get(i);
	        if (e.getIp().equals(ip)) {
	            equipments.remove(i); // remove pelo índice
	            found = true;
	            System.out.println("Equipment with IP " + ip + " removed successfully.");
	            break; // remove only first found
	        }
	    }

	    if (!found) {
	        System.out.println("No equipment found with IP " + ip);
	    }
	}
	
	public static void clearScreen() {
	    for (int i = 0; i <50; i++) {
	        System.out.println();
	    }
	}

}
