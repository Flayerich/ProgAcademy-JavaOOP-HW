package hw52;

import java.util.Scanner;

public class Human {
    private String name;
    private String lastName;
    private Gender gender;
    
    public enum Gender{
    	FEMALE, MALE;
    }

    
	public Human(String name, String lastName, Gender gender) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
	}
	 public void readStudentInfoFromConsole() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Введіть ім'я студента: ");
	        name = sc.nextLine();
	        System.out.print("Введіть прізвище студента: ");
	        lastName = sc.nextLine();
	        sc.close();
	 }
	
	public Human() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return  "Human [name=" + name + ", lastName=" + lastName + ", gender=" + gender + "]";
	}
	
}
