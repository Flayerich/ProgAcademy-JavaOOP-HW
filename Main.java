package hw2;

public class Main {
	public static void main(String[] args) {
        
		Dog dog = new Dog("Meat", "Black", 10, "Sharik");
        System.out.println(dog.toString());
        System.out.println("Dog: " + dog.getName());
        System.out.println("Dog's Voice: " + dog.getVoice());
        dog.eat();
        dog.sleep();
        
        Cat cat = new Cat("Fish", "White", 5, "Kuzya");
        System.out.println(cat.toString());
        System.out.println("Cat: " + cat.getName());
        System.out.println("Cat's Voice: " + cat.getVoice());
        cat.eat();
        cat.sleep();
         Veterinarian vet = new Veterinarian ("Poligraph Sharikovich");
         vet.treatment(cat);
         vet.treatment(dog);
        
	}

}
