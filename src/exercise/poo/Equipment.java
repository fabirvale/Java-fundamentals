package exercise.poo;

public abstract class Equipment {
	private String type;
	private String model;
	private String ip;
	private String manufacturer;
    private String state;
    private Double energyConsumption;
    
	public Equipment(String type, String model, String ip, String manufacturer, String state, Double energyConsumption) {
		this.type = type;
		this.model = model;
		this.ip = ip;
		this.manufacturer = manufacturer;
		this.state = state;
		this.energyConsumption = energyConsumption;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getEnergyConsumption() {
		return energyConsumption;
	}
	public void setEnergyConsumption(Double energyConsumption) {
		this.energyConsumption = energyConsumption;
	}
	
	public abstract void powerOn();
	public abstract void powerOff();
	public abstract void restart();
	public abstract Double calculateConsumption();
    
	@Override
	public String toString() {
		return " Model: " + model
				+ "\n IP: " + ip 
				+ "\n Manufacturer: " + manufacturer
				+ "\n State: " + state 
				+ "\n EnergyConsumption(kWh): " + energyConsumption;
	}
	
	
    
}
