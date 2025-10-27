package exercise.poo;

public class Cat extends Animal {
  
	private String eyeColor;

	public Cat(String name, Integer age, String type, String eyeColor) {
		super(name, age, type);
		this.eyeColor = eyeColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	
	@Override
	public String makeSound() {

		return " Miau Miau Miau";
	}
	
	 @Override
		public String toString() {
			return super.toString() +  "\n Eye Color:" + eyeColor;
		}
}
