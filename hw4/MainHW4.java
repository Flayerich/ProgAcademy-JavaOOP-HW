package hw4;

import hw4.Human.Gender;

public class MainHW4 {

	public static void main(String[] args) {
		Group group = new Group("KT-1");
		
		Student student1 = new Student("Arsen", "Oliyar", Gender.MALE, 1, "KT-1");
		Student student2 = new Student("Olga", "Chayka", Gender.FEMALE, 2, "KT-1");
		Student student3 = new Student("Oleg", "Tyagnybok", Gender.MALE, 3, "KT-1");
		Student student4 = new Student("Yosyp", "Sirko", Gender.MALE, 4, "KT-1");
		Student student5 = new Student("Mihaylo", "Boguslav", Gender.MALE, 5, "KT-1");
		Student student6 = new Student("Valeriy", "Zaluznyi", Gender.MALE, 6, "KT-1");
		Student student7 = new Student("Petro", "Polishchuk", Gender.MALE, 7, "KT-1");
		Student student8 = new Student("Nataliya", "Tyha", Gender.FEMALE, 8, "KT-1");
		Student student9 = new Student("Pavlo", "Boykiv", Gender.MALE, 9, "KT-1");
		
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
			
		} catch (GroupOverflowException e) {		
				System.out.println("Group Overflow");
				e.printStackTrace();
	}
		AddStudent stu = new AddStudent(); // додавання студента з клавіатури
		stu.addStudents(group);
		
		group.sortStudentsByLastName();
		
		System.out.println(group);
	}
}
