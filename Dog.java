package hw2;

class Dog extends Animal {
	private String name;
	
	public Dog(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}
	
	public Dog() {
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
	        return "Гав-Гав";
	    }
	
	@Override
	public void eat() {
		System.out.println("Собачка їсть");
	}
	@Override
	public void sleep() {
		System.out.println("Собачка спить");
	}
	
}
