package hw8;

import java.util.Scanner;


public class AddStudent {
    public Student getInfoForStudent() {
        Scanner sc = new Scanner (System.in);
        Student student = new Student();

        System.out.println("Ведіть імя студента: ");
        String name = sc.nextLine();
        student.setName(name);

        System.out.println("Ведіть прізвище студента: ");
        String lastName = sc.nextLine();
        student.setLastName(lastName);

        System.out.println("Ведіть стать студента (FEMALE або MALE): ");
        String genderInput = sc.nextLine().toUpperCase();
        Human.Gender gender = null;

        try {
            gender = Human.Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: некоректна стать.");
        }

        if (gender != null) {
            student.setGender(gender);
        } else {
            System.out.println("Помилка: некоректна стать.");
        }
        System.out.println("Ведіть назву групи: ");
        String groupName = sc.nextLine();
        student.setGroupName(groupName);

        System.out.println("Ведіть ID студента: ");
        int id = sc.nextInt();
        student.setId(id);

        sc.close();

        return new Student(name, lastName, gender, id, groupName);
    }
    public void addStudents(Group group) {
        try {
            group.addStudent(getInfoForStudent());
            System.out.println("Студента добавлено у групу");
        } catch (GroupOverflowException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}