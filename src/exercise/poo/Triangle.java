package exercise.poo;

public class Triangle {
	private Double sideA;
	private Double sideB;
	private Double sideC;
	
	public Triangle(Double sideA, Double sideB, Double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	public Double getSideA() {
		return sideA;
	}
	public void setSideA(Double sideA) {
		this.sideA = sideA;
	}
	public Double getSideB() {
		return sideB;
	}
	public void setSideB(Double sideB) {
		this.sideB = sideB;
	}
	public Double getSideC() {
		return sideC;
	}
	public void setSideC(Double sideC) {
		this.sideC = sideC;
	}
	
	public Boolean isValid() {
		if (sideA > 0 && sideB > 0 && sideC >0 && sideA < (sideB + sideC) && sideB < (sideA + sideC) && sideC < (sideA + sideB)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Double calculatePerimeter() {
		return sideA + sideB + sideC;
	}

	@Override
	public String toString() {
		return " sideA: " + String.format("%.2f", sideA) 
				+ "\n sideB: " + String.format("%.2f", sideB)
				+ "\n sideC: " + String.format("%.2f", sideC)
				+ "\n Perimeter: "
				+ String.format("%.2f", calculatePerimeter());
	}
	
	

}
