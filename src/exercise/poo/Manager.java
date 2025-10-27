package exercise.poo;

public class Manager extends Employee {
		private Double bonus;

		public Manager(String name, Double grossSalary, Double valueDiscount, String position, Double bonus) {
			super(name, grossSalary, valueDiscount, position);
			this.bonus = bonus;
		}

		public Double getBonus() {
			return bonus;
		}

		public void setBonus(Double bonus) {
			this.bonus = bonus;
		}

		@Override
		public Double calculateNetSalary() {
		   	return (super.getGrossSalary() - (super.getGrossSalary() * (super.getvalueDiscount() / 100)) + bonus);
		}
		
		@Override
		public String toString() {
			return super.toString() + 
				   "\n Bonus $: " + bonus;
		}

		

}
