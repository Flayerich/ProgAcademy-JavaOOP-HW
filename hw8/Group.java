package hw8;

import java.util.Arrays;
import java.util.Objects;


public class Group {
    private String groupName;
    private Student [] students = new Student[10];

    public Group(String groupName) {
        super();
        this.groupName = groupName;
    }

    public Group() {
        super();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException();
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getLastName().equals(lastName)) {
                    return students[i];
                }
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentById(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "Group " + groupName + " Students:" + System.lineSeparator();
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                res+=students[i] + System.lineSeparator();
            }
        }
        return res;
    }
    public void sortStudentsByLastName() {
        Arrays.sort(students, new LastNameComparator());
    }
    @Override           //homework 8
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Group group = (Group) obj;
        return Objects.equals(groupName, group.groupName) &&
                Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(groupName);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
    ///homework 8.2 пошук еквівалентних студентів.
    public boolean areAllStudentsUnique() {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i] != null && students[j] != null && students[i].equals(students[j])) {
                    return false;
                }
            }
        }
        return true;
    }

}
