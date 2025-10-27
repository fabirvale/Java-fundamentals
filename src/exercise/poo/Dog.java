package exercise.poo;

public class Dog extends Animal {

	private String breed;

	public Dog(String name, Integer age, String type, String breed) {
		super(name, age, type);
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String makeSound() {

		return "Au Au Au";
	}
	
	  @Override
		public String toString() {
			return super.toString() +  "\n Breed:" + breed;
	
		}

}
