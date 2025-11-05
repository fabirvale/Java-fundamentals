package exercise.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public void registerEquipment(String type, String model, String ip, String manufacturer, String state,
			double energyConsumption, int qtdHourConsumption, Scanner sc) {
		Equipment e = null;
				
		if (type.equalsIgnoreCase("Router")) {
			System.out.print("Support Wifi (true/false): ");
			boolean supportWifi = sc.nextBoolean();

			System.out.print("Inform Mbps: ");
			int mbps = sc.nextInt();
			sc.nextLine();

			e = new Router(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, supportWifi,
					mbps);
		} else if (type.equalsIgnoreCase("Switch")) {
			System.out.print("Inform Switch Capacity (Gbps): ");
			double portCapacityGB = sc.nextDouble();
			sc.nextLine();

			e = new Switch(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, portCapacityGB);
		} else if (type.equalsIgnoreCase("Server")) {
			sc.nextLine(); // limpar buffer

			System.out.print("Inform Operating System: ");
			String opSystem = sc.nextLine();

			System.out.print("Inform RAM Capacity (GB): ");
			int ramCapacity = sc.nextInt();

			System.out.print("Inform Disk Capacity (GB): ");
			int diskCapacity = sc.nextInt();
			sc.nextLine();

			e = new Server(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption, opSystem,
					ramCapacity, diskCapacity);
		} else if (type.equalsIgnoreCase("Firewall")) {
			System.out.print("Support statefullPacketInspection (true/false): ");
			boolean statefullPacketInspection = sc.nextBoolean();

			System.out.print("Support blockDoS (true/false): ");
			boolean blockDoS = sc.nextBoolean();
			sc.nextLine();

			e = new Firewall(type, model, ip, manufacturer, state, energyConsumption, qtdHourConsumption,
					statefullPacketInspection, blockDoS);
		}

		if (e != null) {
			equipments.add(e);
			System.out.println("Equipment registered successfully!");
		} else {
			System.out.println("Unknown equipment type!");
		}
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
	    return state != null &&
	           (state.equalsIgnoreCase("on") || state.equalsIgnoreCase("off"));
	}

	public boolean isValidEnergy(Double energy) {
	    return energy != null && energy > 0;
	}
	
	public boolean isValidConsumptionHours(int hours) {
	    return hours > 0 && hours <= 24;
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
		if (op.equalsIgnoreCase("Turn on")) 
		  {
			equipment.setState("on");
			equipment.powerOn();
		   
		 } 
		 else if (op.equalsIgnoreCase("Turn off"))
		  {
			 equipment.setState("off");
			 equipment.powerOff();
		   }
		 else {
				equipment.restart();
			  }
	}
	
	public void showEnergyReport(Equipment equipment) {
		System.out.println();
		System.out.println(equipment.toString() 
     		                         + "\n Consumption/Day: " + equipment.calculateConsumption(equipment.getQtdHourConsumption()));
		System.out.println("=======================================================================================");    
		System.out.println();
	}
	
	public void showStateReport(Equipment equipment) {
		System.out.println();
		System.out.println(" Model: " + equipment.getModel()
		                   + "\n IP: " + equipment.getIp()
		                   + "\n Manufacturer: " + equipment.getManufacturer()
		                   + "\n State: " + equipment.getState());
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
}
