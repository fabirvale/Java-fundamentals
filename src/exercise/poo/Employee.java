package exercise.poo;

public class Employee {
	
	private String name;
	private Double grossSalary;
	private Double valueDiscount;
	
	
	public Employee(String name, Double grossSalary) {
		this.name = name;
		this.grossSalary = grossSalary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
		
	public Double getValueDiscount() {
		return valueDiscount;
	}
	public void setValueDiscount(Double valueDiscount) {
		this.valueDiscount = valueDiscount;
	}
	
	public Double calculateNetSalary(Double discount) {
		if (discount < 0 || discount > 100) {
	        throw new IllegalArgumentException("Invalid discount percentage.");
	    }
	    valueDiscount = grossSalary * (discount / 100);
		return grossSalary - valueDiscount;
	}
	@Override
	public String toString() {
		return " Employee: " + name 
				+ "\n Gross Salary: $" + String.format("%.2f", grossSalary);
	}
    
	
}
