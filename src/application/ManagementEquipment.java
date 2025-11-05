package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercise.poo.Equipment;
import exercise.poo.EquipmentService;

public class ManagementEquipment {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		EquipmentService eqService = new EquipmentService();
		int option, qtdHourConsumption;
		String type, model, ip, manufacturer, state;
		double energyConsumption;

		showMenu();

		do {

			System.out.print("Choose the option: ");
			option = sc.nextInt();
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

				while (true) {
					System.out.print("Type (Router / Switch / Server / Firewall): ");
					type = sc.nextLine().trim();
					if (!eqService.isValidType(type)) {
						System.out.println("Unknown equipment type! Please enter a valid operation.");
					} else {
						break;
					}
				}

				while (true) {
					System.out.print("Inform the model: ");
					model = sc.nextLine();
					if (!eqService.isValidModel(model)) {
						System.out.println("Model cannot be empty!Try again");
					} else {
						break;
					}
				}

				while (true) {
					System.out.print("Inform the IP: ");
					ip = sc.nextLine();

					if (!eqService.validarIP(ip)) {
						System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
						continue; // volta para o início do loop
					}

					if (eqService.isDuplicateIp(ip)) {
						System.out.println("This IP already was registered! Inform other IP.");
						continue; // return to the beginning of the loop
					}

					break; // Exit the loop — IP is valid and unique
				}

				while (true) {
					System.out.print("Inform the Manufacturer: ");
					manufacturer = sc.nextLine();
					if (!eqService.isValidManufacturer(manufacturer)) {
						System.out.println("Manufacturer cannot be empty!Try again");
					} else {
						break;
					}
				}

				while (true) {
					System.out.print("State (on/off): ");
					state = sc.nextLine();
					if (eqService.isValidState(state))
						break;
					System.out.println("Invalid state! Must be 'on' or 'off'.");
				}

				while (true) {
					System.out.print("Energy Consumption (W): ");
					energyConsumption = sc.nextDouble();
					try {
						if (eqService.isValidEnergy(energyConsumption))
							break;
						System.out.println("Energy consumption must be positive!");
					} catch (NumberFormatException e) {
						System.out.println("Invalid number! Try again.");
					}
				}

				while (true) {
					System.out.print("Consumption/Day : ");
					qtdHourConsumption = sc.nextInt();
					try {
						if (eqService.isValidConsumptionHours(qtdHourConsumption))
							break;
						System.out.println("Consumption/Day must be positive!");
					} catch (NumberFormatException e) {
						System.out.println("Invalid number! Try again.");
					}

				}
				eqService.registerEquipment(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption,
						sc);

				break;
			case 2:
				clearScreen();
				printListEquipments(eqService.getEquipments());
				break;
			case 3:
				clearScreen();
			    if (eqService.getEquipments().isEmpty()) {
			        System.out.println("No equipment registered yet.");
			    } else {
			        Equipment foundIpList = null;

			        while (true) {
			            System.out.print("Which of the operations would you like to execute (Turn On / Turn Off / Restart)? ");
			            String op = sc.nextLine().trim();

			            if (!(op.equalsIgnoreCase("Turn On") || op.equalsIgnoreCase("Turn Off") || op.equalsIgnoreCase("Restart"))) {
			                System.out.println("Unknown operation! Please enter a valid type.");
			                continue;
			            }

			            System.out.print("Inform the IP: ");
			            ip = sc.nextLine();

			            if (!eqService.validarIP(ip)) {
			                System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
			                continue;
			            }

			            foundIpList = eqService.ipSearch(ip);

			            if (foundIpList == null) {
			                System.out.println("No equipment found with IP " + ip);
			                break;
			            }

			            if (op.equalsIgnoreCase("Turn On") && foundIpList.getState().equalsIgnoreCase("on")) {
			                System.out.println("The equipment has already been turned on");
			                break;
			            }

			            if (op.equalsIgnoreCase("Turn Off") && foundIpList.getState().equalsIgnoreCase("off")) {
			                System.out.println("The equipment has already been turned off");
			                break;
			            }

			            if (op.equalsIgnoreCase("Restart") && foundIpList.getState().equalsIgnoreCase("off")) {
			                System.out.println("The equipment is off! Turn it on before restarting.");
			                break;
			            }

			            eqService.executeOperation(op, foundIpList);
			            break;
			        }
			    }
			    break;
			case 4:
				 clearScreen();
				 if (eqService.getEquipments().isEmpty()) {
				        System.out.println("No equipment registered yet.");
				 }
                 else {
				        Equipment foundIpList = null;
				        while (true)
				        {
				          System.out.println("================================== ENERGY REPORT ===================================");
				     	  System.out.print("Inform the IP:"); 
			              ip = sc.nextLine();
			              if (!eqService.validarIP(ip))
			              {
							 System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
							  continue; //go back to the beginning of the loop
			               }
			               else{
			            	   foundIpList = eqService.ipSearch(ip);
			            	   
			            	   if (foundIpList == null) {
			                       System.out.println("No equipment found with IP " + ip);
			                       break; // Exit the loop,there is no equipment
			                   }
			            	   eqService.showEnergyReport(foundIpList);
			            	   break;
			                }
				        	
				        }

				    }
				break;
			case 5:
				 clearScreen();
				 if (eqService.getEquipments().isEmpty()) {
				        System.out.println("No equipment registered yet.");
				 }
                 else {
				        Equipment foundIpList = null;
				        while (true)
				        {
				          System.out.println("================================== STATE REPORT ===================================");
				     	  System.out.print("Inform the IP:"); 
			              ip = sc.nextLine();
			              if (!eqService.validarIP(ip))
			              {
							 System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
							  continue; //go back to the beginning of the loop
			               }
			               else{
			            	   foundIpList = eqService.ipSearch(ip);
			            	   
			            	   if (foundIpList == null) {
			                       System.out.println("No equipment found with IP " + ip);
			                       break; // Exit the loop,there is no equipment
			                   }
			            	   eqService.showStateReport(foundIpList);
			            	   break;
			                }
				        	
				        }

				    }
				break;
				 
			case 6:
				clearScreen();
				 if (eqService.getEquipments().isEmpty()) {
				        System.out.println("No equipment registered yet.");
				 }
                else {
				        Equipment foundIpList = null;
				        while (true)
				        {
				          System.out.println("==================================Search Equipment by IP===================================");
				     	  System.out.print("Inform the IP:"); 
			              ip = sc.nextLine();
			              if (!eqService.validarIP(ip))
			              {
							 System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
							  continue; //go back to the beginning of the loop
			               }
			               else{
			            	   foundIpList = eqService.ipSearch(ip);
			            	   
			            	   if (foundIpList == null) {
			                       System.out.println("No equipment found with IP " + ip);
			                       break; // Exit the loop,there is no equipment
			                   }
			            	   System.out.println(foundIpList.toString());
			            	   break;
			                }
				        	
				        }

				    }
				break;
			case 7:
				clearScreen();
				 if (eqService.getEquipments().isEmpty()) {
				        System.out.println("No equipment registered yet.");
				 }
               else {
				        Equipment foundIpList = null;
				        while (true)
				        {
				          System.out.println("==================================Search Equipment by IP===================================");
				     	  System.out.print("Inform the IP:"); 
			              ip = sc.nextLine();
			              if (!eqService.validarIP(ip))
			              {
							 System.out.println("Invalid IP format! Try again (e.g. 192.168.0.10)");
							  continue; //go back to the beginning of the loop
			               }
			               else{
			            	   foundIpList = eqService.ipSearch(ip);
                              if (foundIpList == null) {
			                       System.out.println("No equipment found with IP " + ip);
			                       break; // Exit the loop,there is no equipment
			                   }
			            	   int index = eqService.getEquipments().indexOf(foundIpList);
			            	   
			            	   if (eqService.removeEquipmentByIP(index)) {
			            	      System.out.println("Equipment with IP " + ip + " removed successfully.");
			            	      break;
			            	   }
			                  else {
			                       System.out.println("Error removing equipment with IP " + ip);
			                       break;
			                   }
			            	   
			                }
				        	
				        }

				    }
				break;
			default:
				System.out.println("Exiting the program...");
			}
		  System.out.println();
		} while (option != 8);

		sc.close();
	}

	public static void showMenu() {
		// clearScreen(); // clean the screean
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

	public static void printListEquipments(List<Equipment> equipments) {
		System.out.println();
		System.out.println(
				"===========================================EQUIPMENTS LIST======================================================================");
		System.out.println();
		if (equipments.isEmpty()) {
			System.out.println("No equipment registered yet.");
		} else {
			// Cabeçalho da tabela
			System.out.printf("%-10s %-12s %-16s %-15s %-10s %-15s %-15s %-50s%n", "Type", "Model", "IP",
					"Manufacturer", "State", "Energy(W)", "Consumption/Day(KWh)", "Specific Info");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------");

			// lines of table
			for (Equipment e : equipments) {
				// Exibe uma linha formatada
				System.out.printf("%-10s %-12s %-16s %-15s %-10s %-15.2f %20d %-50s%n", e.getType(), e.getModel(),
						e.getIp(), e.getManufacturer(), e.getState(), e.getEnergyConsumption(),
						e.getQtdHourConsumption(), e.getDetails());
			}
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}

}
