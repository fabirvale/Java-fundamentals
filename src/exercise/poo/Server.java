package exercise.poo;

public class Server extends Equipment{
	private String opSystem;
	private int ramCapacity;
	private int diskCapacity;
	
	public Server(String type, String model, String ip, String manufacturer, String state, Double energyConsumption,
			String opSystem, int ramCapacity, int diskCapacity) {
		super(type, model, ip, manufacturer, state, energyConsumption);
		this.opSystem = opSystem;
		this.ramCapacity = ramCapacity;
		this.diskCapacity = diskCapacity;
	}

	public String getOpSystem() {
		return opSystem;
	}

	public void setOpSystem(String opSystem) {
		this.opSystem = opSystem;
	}

	public int getRamCapacity() {
		return ramCapacity;
	}

	public void setRamCapacity(int ramCapacity) {
		this.ramCapacity = ramCapacity;
	}

	public int getDiskCapacity() {
		return diskCapacity;
	}

	public void setDiskCapacity(int diskCapacity) {
		this.diskCapacity = diskCapacity;
	}
	
	@Override
	public void powerOn() {
		System.out.println("The server " + super.getModel() + " initializing Network Services.");
	}
	
	@Override
	public  void powerOff() {
		System.out.println("The server " + super.getModel() + " turning off... Disconnecting from networks.");
	}
	
	@Override
	public  void restart() {
		System.out.println("Restarting the server " + super.getModel());
		
	}
	
	@Override
	public Double calculateConsumption() {
		return (super.getEnergyConsumption() * 24) / 1000;
	}

	@Override
	public String toString() {
		return super.toString() 
			   + "\n Operating System: " + opSystem
			   + "\n RAM Capacity: " + ramCapacity
			   + "\n Disk Capacity: " + diskCapacity;
	}
	

}
