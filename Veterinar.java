package hw2;

class Veterinarian {
	private String name;
	
	public Veterinarian(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Veterinarian() {
		super();
	}
	
	
	public void treatment(Animal animal) {
		System.out.println(name + " лікує тваринку: " + animal.getRation() + ", колір: " 
				+ animal.getColor() + ", і вага: " 
				+ animal.getWeight());
	}
}
