package exercise.poo;

public class Product {

	private String name;
	private Double price;
	private Integer quantity;

	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		
		if (price < 0) {
	        throw new IllegalArgumentException("Price cannot be negative.");
	    }
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		if (quantity < 0) {
	        throw new IllegalArgumentException("Quantity cannot be negative.");
	    }
		this.quantity = quantity;
	}

	public Double totalValueInStock() {
		if (quantity <= 0) {
			return 0.0;
		}
		return price * quantity;
	}

	@Override
	public String toString() {
		return " Product Name: " + name
				+ "\n Price: $" + String.format("%.2f", price)
				+ "\n Quantity: " + quantity
				+ "\n Total value in Stock: $" + String.format("%.2f", totalValueInStock());
	}

}
