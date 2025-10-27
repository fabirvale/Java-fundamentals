package exercise.poo;

public class Seller extends Employee{
	private Double totalSales;
	private Double commission;
	public Seller(String name, Double grossSalary, Double discount, String position, Double totalSales, Double commission) {
		super(name, grossSalary, discount, position);
		this.totalSales = totalSales;
		this.commission = commission;
	}
	public Double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(Double totalSales) {
		this.totalSales = totalSales;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	
	@Override
	public Double calculateNetSalary() {
		  	return (super.getGrossSalary() -(super.getGrossSalary() * (super.getvalueDiscount() / 100))) + 
	   			(totalSales * (commission / 100));
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\n Total sales $: " + totalSales 
				+ "\n Percentual Commission(%): " + commission;
	}


}
