package hw8;
import hw8.Human.Gender;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Іван", "Попович", Human.Gender.MALE);
        Human human2 = new Human("Іван", "Попович", Human.Gender.MALE);
        Human human3 = new Human("Марія", "Луценко", Human.Gender.FEMALE);

        // Порівняння об'єктів класу Human
        System.out.println("Human1 та Human2: " + human1.equals(human2)); // Повинно бути true
        System.out.println("Human1 та Human3: " + human1.equals(human3)); // Повинно бути false

        // Створення об'єктів класу Student
        Student student1 = new Student("Arsen", "Oliyar", Gender.MALE, 1, "KT-1");
        Student student2 = new Student("Arsen", "Oliyar", Gender.MALE, 1, "KT-1");
        Student student3 = new Student("Oleg", "Tyagnybok", Gender.MALE, 3, "KT-1");
        Student student4 = new Student("Yosyp", "Sirko", Gender.MALE, 4, "KT-1");
        Student student5 = new Student("Mihaylo", "Boguslav", Gender.MALE, 5, "KT-1");
        Student student6 = new Student("Valeriy", "Zaluznyi", Gender.MALE, 6, "KT-1");
        Student student7 = new Student("Petro", "Polishchuk", Gender.MALE, 7, "KT-1");
        Student student8 = new Student("Nataliya", "Tyha", Gender.FEMALE, 8, "KT-1");
        Student student9 = new Student("Pavlo", "Boykiv", Gender.MALE, 9, "KT-1");

        // Порівняння об'єктів класу Student
        System.out.println("Student1 та Student2: " + student1.equals(student2)); // Повинно бути true
        System.out.println("Student1 та Student3: " + student1.equals(student3)); // Повинно бути false

        // Створення об'єктів класу Group
        Group group1 = new Group("Група1");
        Group group2 = new Group("Група2");
        Group group3 = new Group("Група3");
        try {
            group1.addStudent(student1);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group2.addStudent(student2);/// перевірити можна змінивши group1 на group2
            group3.addStudent(student3);
            System.out.println("Чи всі студенти у групі унікальні? " + group1.areAllStudentsUnique());
        }catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        // Порівняння об'єктів класу Group
        System.out.println("Group1 та Group2: " + group1.equals(group2)); // Повинно бути true або false залежно від реалізації
        System.out.println("Group1 та Group3: " + group1.equals(group3)); // Повинно бути false
    }
}
