package exercise.poo;

public class Person {
	
	private String name;
	private Integer age;
		
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
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
	
	public void introduce() {
		System.out.println("Hello, my name is " + name + " and  I'm " + age + " years old.");		
	}

}
