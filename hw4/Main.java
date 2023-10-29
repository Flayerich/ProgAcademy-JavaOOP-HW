package hw4;

import hw4.Human.Gender;

public class Main {

	public static void main(String[] args) {

		Student student1 = new Student("Arsen", "Oliyar", Gender.MALE, 1, "KT-1");
		Student student2 = new Student("Olga", "Chayka", Gender.FEMALE, 2, "KT-1");
		Student student3 = new Student("Oleg", "Tyagnybok", Gender.MALE, 3, "KT-1");
		Student student4 = new Student("Yosyp", "Sirko", Gender.MALE, 4, "KT-1");
		Student student5 = new Student("Mihaylo", "Boguslav", Gender.MALE, 5, "KT-1");
		Student student6 = new Student("Valeriy", "Zaluznyi", Gender.MALE, 6, "KT-1");
		Student student7 = new Student("Petro", "Polishchuk", Gender.MALE, 7, "KT-1");
		Student student8 = new Student("Nataliya", "Tyha", Gender.FEMALE, 8, "KT-1");
		Student student9 = new Student("Pavlo", "Boykiv", Gender.MALE, 9, "KT-1");
		Student student10 = new Student("Mariya", "Oliynyk", Gender.FEMALE, 10, "KT-1");
		Student student11 = new Student("Stefaniya", "Mishchenko", Gender.FEMALE,11, "KT-1");
		
		Group group = new Group ("KT-1");
		
		System.out.println(group);  //створюємо групу, в даний момент в ній нема жодного студента.

		try { 
			group.addStudent(student1);
			group.addStudent(student2);
			group.addStudent(student3);
			group.addStudent(student4);
			group.addStudent(student5);
			group.addStudent(student6);
			group.addStudent(student7);
			group.addStudent(student8);
			group.addStudent(student9);
			group.addStudent(student10);
			
			group.removeStudentById(10);  // видалення студента з групи 
			
			group.addStudent(student11); // додавання студента у групу
			
		} catch (GroupOverflowException e) {		
				System.out.println("Group Overflow");
				e.printStackTrace();
	}	
		try {														// пошук студента у групі
			System.out.println("Search student by last name: ");
			System.out.println(group.searchStudentByLastName("Chayka"));
		} catch (StudentNotFoundException e) {
			 e.printStackTrace(); 
		} 
		
		AddStudent stu = new AddStudent(); // додавання студента з клавіатури
		stu.addStudents(group);
	}
}
