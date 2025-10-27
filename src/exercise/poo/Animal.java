package exercise.poo;

public class Animal {
	
	private String name;
	private Integer age;
	private String type;
	
	public Animal(String name, Integer age, String type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
    public String makeSound() {
     	return "Generic animal sound";
    }
    
    @Override
	public String toString() {
		return " Name:" + name 
				+ "\n Age:" + age 
				+ "\n Type:" + type
				+ "\n Animal's Sound: " + makeSound();
				
	}

}
