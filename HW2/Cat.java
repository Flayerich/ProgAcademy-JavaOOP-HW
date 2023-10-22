package hw2;

class Cat extends Animal {
	
	private String name;
	
	public Cat(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}
	
	public Cat() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getVoice() {
		return "Мяу-мяу";
	}
	
	@Override
	public void eat() {
		System.out.println("Котик ість");
	}
	
	@Override
	public void sleep() {
		System.out.println("Котик спить");
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", getName()=" + getName() + ", getVoice()=" + getVoice() + ", getRation()="
				+ getRation() + ", getColor()=" + getColor() + ", getWeight()=" + getWeight() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
