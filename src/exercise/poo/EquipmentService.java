package exercise.poo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentService {

	List<Equipment> equipments = new ArrayList<>();

	public EquipmentService() {

	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public Boolean registerEquipment(String type, String model, String ip, String manufacturer,
			String state, Double energyConsumption, Integer qtdHourConsumption, Boolean supportWifi, Integer mbps,
			Double portCapacityGB, String opSystem, Integer ramCapacity, Integer diskCapacity,
			Boolean statefullPacketInspection, Boolean blockDoS) {

		Equipment e = null;

		// === create the specific object ===
		if (type.equalsIgnoreCase("Router")) {
			e = new Router(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, supportWifi,
					mbps);
		} else if (type.equalsIgnoreCase("Switch")) {
			 e = new Switch(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, portCapacityGB);
		} else if (type.equalsIgnoreCase("Server")) {
			 e = new Server(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, opSystem,
					ramCapacity, diskCapacity);
		} else if (type.equalsIgnoreCase("Firewall")) {
			e = new Firewall(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption,
					statefullPacketInspection, blockDoS);
		}

		// === Case the type unknown ===
		if (e == null) {
			System.out.println("Unknown equipment type!");
			return false;
		}

		// === Add in the list ===
		equipments.add(e);
		return true;

	}

	public boolean isValidType(String type) {
		// check if type is valid
		if (type.equalsIgnoreCase("Router") || type.equalsIgnoreCase("Switch") || type.equalsIgnoreCase("Server")
				|| type.equalsIgnoreCase("Firewall")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidModel(String model) {
		return model != null && !model.trim().isEmpty();
	}

	public boolean validarIP(String ip) {
		String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		return ip.matches(regex);
	}

	public boolean isDuplicateIp(String ip) {
		for (Equipment e : equipments) {
			if (e.getIp().equals(ip)) {
				return true; // there is IP in list
			}
		}
		return false; // there is no IP in list
	}

	public boolean isValidManufacturer(String manufacturer) {
		return manufacturer != null && !manufacturer.trim().isEmpty();
	}

	public boolean isValidState(String state) {
		return state != null && (state.equalsIgnoreCase("on") || state.equalsIgnoreCase("off"));
	}

	public boolean isValidEnergy(Double energy) {
		return energy != null && energy > 0;
	}

	public boolean isValidConsumptionHours(int hours) {
		return hours > 0 && hours <= 24;
	}

	public boolean isValidosSystem(String osSystem) {
		return osSystem != null && !osSystem.trim().isEmpty();
	}

	public boolean isValidInteger(Integer value) {
		return value != null && value > 0;
	}

	public boolean isValidDouble(Double value) {
		return value != null && value > 0;
	}

	public boolean isValidBoolean(String input) {
		return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no");
	}

	public Equipment ipSearch(String ip) {
		for (Equipment e : equipments) {
			if (e.getIp().equals(ip)) {
				return e;
			}
		}
		return null;
	}

	public void executeOperation(String op, Equipment equipment) {
		if (op.equalsIgnoreCase("Turn on")) {
			equipment.setState("on");
			equipment.powerOn();

		} else if (op.equalsIgnoreCase("Turn off")) {
			equipment.setState("off");
			equipment.powerOff();
		} else {
			equipment.restart();
		}
	}

	public void showEnergyReport(Equipment equipment) {
		System.out.println();
		System.out.println(equipment.toString() + "\n Consumption/Day: "
				+ equipment.calculateConsumption(equipment.getQtdHourConsumption()));
		System.out.println("=======================================================================================");
		System.out.println();
	}

	public void showStateReport(Equipment equipment) {
		System.out.println();
		System.out.println(" Model: " + equipment.getModel() + "\n IP: " + equipment.getIp() + "\n Manufacturer: "
				+ equipment.getManufacturer() + "\n State: " + equipment.getState());
		System.out.println("=======================================================================================");
		System.out.println();
	}

	public boolean removeEquipmentByIP(Integer index) {
		if (index >= 0 && index < equipments.size()) {
			equipments.remove((int) index);
			return true;
		}
		return false;
	}

	public void loadFromFile() {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\temp\\out\\equipments.csv"))) {

			String[] vetEquipment;
			int i = 0;

			String line = br.readLine();

			while (line != null) {
				i++;
				vetEquipment = line.split(";");
				createEquipmentFromLine(vetEquipment, i);
				line = br.readLine();

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void createEquipmentFromLine(String[] vetEquipment, Integer line) {
		Integer qtdHourConsumption, mbps, ramCapacity, diskCapacity;
		String type, model, ip, manufacturer, state, opSystem;
		Double energyConsumption, portCapacityGB;
		Boolean supportWifi, statefullPacketInspection, blockDoS;
		
		Equipment eq = null;

		// Validate length of vector
		if (vetEquipment.length < 7) {
			System.out.println("Line " + line + " ignored: missing basic fields (expected at least 7, found "
					+ vetEquipment.length + ").");
			return;
		}

		// validate Type
		if (isValidType(vetEquipment[0])) {
			type = vetEquipment[0];
		} else {
			System.out.println("Line " + line + " ignored : invalid Type.");
			return;
		}
		// validate Type
		if (isValidModel(vetEquipment[1])) {
			model = vetEquipment[1];
		} else {
			System.out.println("Line " + line + " ignored : invalid Model.");
			return;
		}

		// validate IP
		if (validarIP(vetEquipment[2])) {
			ip = vetEquipment[2];

			if (isDuplicateIp(ip)) {
				System.out.println("Line " + line + " ignored : This IP already was registered!.");
				return;
			}
		} else {
			System.out.println("Line " + line + " ignored : Invalid IP format.");
			return;
		}

		// validate manufacturer
		if (isValidManufacturer(vetEquipment[3])) {
			manufacturer = vetEquipment[3];
		} else {
			System.out.println("Line " + line + " ignored : invalid Manufacturer.");
			return;
		}

		// validate State
		if (isValidState(vetEquipment[4])) {
			state = vetEquipment[4];
		} else {
			System.out.println("Line " + line + " ignored : invalid State.");
			return;
		}

		// validate energyConsumption
		try {
			double energyValue = Double.parseDouble(vetEquipment[5]);

			if (isValidEnergy(energyValue)) {
				energyConsumption = energyValue;
			} else {
				System.out.println("Line " + line + " ignored : invalid energy consumption.");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + line + " ignored : invalid energy value.");
			return;
		}

		// validate qtdHourConsumption
		try {
			int qtd = Integer.parseInt(vetEquipment[6]);
			if (isValidConsumptionHours(qtd)) {
				qtdHourConsumption = qtd;
			} else {
				System.out.println("Line " + line + " ignored : Invalid the number of hours of use.");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Line " + line + " ignored : invalid number of hours of use value.");
			return;
		}

		if (type.equalsIgnoreCase("Router")) {
		    if (vetEquipment.length < 9) {
		        System.out.println("Line " + line + " ignored: missing fields for Router.");
		        return;
		    }

		    // === Validate supportWifi ===
		    String answer = vetEquipment[7].trim().toLowerCase();
		    if (!answer.equals("true") && !answer.equals("false")) {
		        System.out.println("Line " + line + " ignored: Invalid boolean value.");
		        return;
		    }
		    supportWifi = Boolean.parseBoolean(answer);
		    
		    // === Validate Mbps ===
		    try {
		        mbps = Integer.parseInt(vetEquipment[8]);
		        if (!isValidInteger(mbps)) {
		            System.out.println("Line " + line + " ignored: Mbps must be positive.");
		            return;
		        }
		    } catch (NumberFormatException e) {
		        System.out.println("Line " + line + " ignored: invalid Mbps value.");
		        return;
		    }

		    // === Create and add Router ===
		    eq = new Router(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, supportWifi, mbps);
		    equipments.add(eq);
		}
  
		else if (type.equalsIgnoreCase("Switch")) {
			if (vetEquipment.length < 8) {
				System.out.println("Line " + line + " ignored: missing fields for Switch.");
				return;
			}
			//validate portCapacityGB
			portCapacityGB = Double.parseDouble(vetEquipment[7]);
			 try {
	                if (!isValidDouble(portCapacityGB)) {
	                	System.out.println("Line " + line + " ignored: portCapacityGB must be positive.");
		                return;
	                }   
	            } catch (NumberFormatException e) {
	            	 System.out.println("Line " + line + " ignored: portCapacityGB value.");
	 		         return;
	            }
			
			eq = new Switch(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption,
					portCapacityGB);
			equipments.add(eq);
		}

		else if (type.equalsIgnoreCase("Server")) {

			if (vetEquipment.length < 10) {
				System.out.println("Line " + line + " ignored: missing fields for Server.");
				return;
			}
			
			 //validate opSystem
		    if (isValidosSystem(vetEquipment[7])) {
		        opSystem = vetEquipment[7];
		    } else {
		        System.out.println("Line " + line + " ignored : Invalid Operating System.");
		        return;
		    }

			//validate ramCapacity
			ramCapacity = Integer.parseInt(vetEquipment[8]);
			 try {
	                if (!isValidInteger(ramCapacity)) {
	                	System.out.println("Line " + line + " ignored: ramCapacity must be positive.");
		                return;
	                }   
	            } catch (NumberFormatException e) {
	            	 System.out.println("Line " + line + " ignored: ramCapacity value.");
	 		         return;
	            }
			 //validate diskCapacity
			diskCapacity = Integer.parseInt(vetEquipment[9]);
			try {
	                if (!isValidInteger(diskCapacity)) {
	                	System.out.println("Line " + line + " ignored: diskCapacity must be positive.");
		                return;
	                }   
	            } catch (NumberFormatException e) {
	            	 System.out.println("Line " + line + " ignored: diskCapacity value.");
	 		         return;
	            }
			eq = new Server(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, opSystem,
					ramCapacity, diskCapacity);
			equipments.add(eq);
		}

		else {
			if (vetEquipment.length < 8) {
				System.out.println("Line " + line + " ignored: missing fields for Firewall.");
				return;
			}
			//validate statefullPacketInspection
			String answer = vetEquipment[7].trim().toLowerCase();
			if (!answer.equals("true") && !answer.equals("false")) {
			        System.out.println("Line " + line + " ignored: Invalid boolean value.");
			        return;
			    }
			  statefullPacketInspection = Boolean.parseBoolean(answer);
			    
			//validate blockDoS  
			answer = vetEquipment[8].trim().toLowerCase();
			if (!answer.equals("true") && !answer.equals("false")) {
		        System.out.println("Line " + line + " ignored: Invalid boolean value.");
		        return;
		    }
			blockDoS = Boolean.parseBoolean(answer);
		    
			eq = new Firewall(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption,
					statefullPacketInspection, blockDoS);
			equipments.add(eq);
		}
	}
	
	public void saveToFile() {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\temp\\out\\equipments.csv", false))) {

	        for (Equipment e : equipments) {
	            String line = e.getType() + ";" +
	                    e.getModel() + ";" +
	                    e.getIp() + ";" +
	                    e.getManufacturer() + ";" +
	                    e.getState() + ";" +
	                    e.getEnergyConsumption() + ";" +
	                    e.getQtdHourConsumption();

	            // specific fields by type
	            if (e instanceof Router) {
	                Router r = (Router) e;
	                line += ";" + r.getSuportWifi() + ";" + r.getMbps();
	            } 
	            else if (e instanceof Switch) {
	                Switch s = (Switch) e;
	                line += ";" + s.getPortCapacityGB();
	            } 
	            else if (e instanceof Server) {
	                Server s = (Server) e;
	                line += ";" + s.getOpSystem() + ";" + s.getRamCapacity() + ";" + s.getDiskCapacity();
	            } 
	            else if (e instanceof Firewall) {
	                Firewall f = (Firewall) e;
	                line += ";" + f.isStatefullPacketInspection() + ";" + f.isBlockDoS();
	            }

	            bw.write(line);
	            bw.newLine();
	        }

	        System.out.println("Equipments successfully saved to file.");

	    } catch (IOException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}


}
