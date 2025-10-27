package exercise.poo;

public class Employee {
	
	private String name;
	private Double grossSalary;
	private Double valueDiscount;
	private String position;	
	
	public Employee(String name, Double grossSalary, Double valueDiscount, String position) {
		this.name = name;
		this.grossSalary = grossSalary;
		setvalueDiscount(valueDiscount); // valid the discount
		this.position = position;
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
		
	public String getPosition () {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Double getvalueDiscount () {
		return valueDiscount;
	}
	
	public void setvalueDiscount(Double valueDiscount) {
		if (valueDiscount < 0 || valueDiscount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100%");
        }
        this.valueDiscount = valueDiscount;
	}
	
	
	public Double calculateNetSalary() {
	 	return grossSalary - (grossSalary * (valueDiscount/100));
	}
	
	@Override
	public String toString() {
		return " Employee: " + name 
				+ "\n Position: " + position
				+ "\n Gross Salary $: " + String.format("%.2f", grossSalary)
		        + "\n Value Discount(%): " + valueDiscount;
	}
    
	
}
