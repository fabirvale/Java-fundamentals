package exercise.poo;

public class Rectangle {
	private Double width;
	private Double height;

	public Rectangle(Double width, Double height) {
		this.width = width;
		this.height = height;
	}
	
	public Double getWidth() {
		return width;
	}
	
	public void setWidth(Double width) {
		
		if (width <= 0) {
	        throw new IllegalArgumentException("Width must be positive.");
	    }
		this.width = width;
	}
	
	public Double getHeight() {
		return height;
	}
    
	public void setHeight(Double height) {
		if (height <= 0) {
	        throw new IllegalArgumentException("height must be positive.");
	    }
		this.height = height;
	}
	
	public Double calculateArea() {
		return width * height;
	}

	public Double calculatePerimeter() {
		return 2 * (width + height);
	}

	@Override
	public String toString() {
		return " Width: " + String.format("%.2f",getWidth()) 
		        + "\n Height: " + String.format("%.2f",getHeight())
		        + "\n Area: " 	+ String.format("%.2f",calculateArea())
		        + "\n Perimeter: " + String.format("%.2f",calculatePerimeter());
	}
	
	
}
