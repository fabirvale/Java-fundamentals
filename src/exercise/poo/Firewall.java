package exercise.poo;

public class Firewall extends Equipment {
	private boolean statefullPacketInspection;//indicates whether the firewall performs stateful packet inspection (SPI)
	private boolean blockDoS; //indicates whether the firewall has protection against DoS (Denial of Service) attacks
	
	public Firewall(String type, String model, String ip, String manufacturer, String state, Double energyConsumption,
			boolean statefullPacketInspection, boolean blockDoS) {
		super(type, model, ip, manufacturer, state, energyConsumption);
		this.statefullPacketInspection = statefullPacketInspection;
		this.blockDoS = blockDoS;
	}
	

	public boolean isStatefullPacketInspection() {
		return statefullPacketInspection;
	}

	public void setStatefullPacketInspection(boolean statefullPacketInspection) {
		this.statefullPacketInspection = statefullPacketInspection;
	}

	public boolean isBlockDoS() {
		return blockDoS;
	}

	public void setBlockDoS(boolean blockDoS) {
		this.blockDoS = blockDoS;
	}

	
	@Override
	public void powerOn() {
		System.out.println("Firewall turning on... Connecting to networks.");
	}
	
	@Override
	public  void powerOff() {
		System.out.println("Firewall turning off... Disconnecting to networks.");
	}
	
	@Override
	public  void restart() {
		System.out.println("Firewall is restarting up...Connecting to networks.");
	}
	
	@Override
	public Double calculateConsumption() {
		return (super.getEnergyConsumption() * 24) / 1000;
	}
    
	@Override
	public String toString() {
		return super.toString() 
			   + "\n StatefullPacketInspection: " + statefullPacketInspection 
			   + "\n BlockDoS: " + blockDoS;
	}
	

}
