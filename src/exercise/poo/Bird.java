package exercise.poo;

public class Bird extends Animal{
	private Boolean knowsHowToSing;

	public Bird(String name, Integer age, String type, Boolean knowsHowToSing) {
		super(name, age, type);
		this.knowsHowToSing = knowsHowToSing;
	}

	public Boolean getKnowsHowToSing() {
		return knowsHowToSing;
	}

	public void setKnowsHowToSing(Boolean knowsHowToSing) {
		this.knowsHowToSing = knowsHowToSing;
	}
	
	@Override
	public String makeSound() {

		return " Piu-piu-piu";
	}
	
	 @Override
		public String toString() {
			return super.toString() + "\n HowToSing:" + knowsHowToSing;
		}
	
}
