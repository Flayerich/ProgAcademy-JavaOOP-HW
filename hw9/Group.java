package hw9;

import java.util.*;
import java.util.stream.Collectors;



public class Group {
    private String groupName;
    private List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public Group() {
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students); // повернення копії списку для інкапсуляції
    }

    public void setStudents(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if (students.size() >= 10) {
            throw new GroupOverflowException("Група переповнена");
        }
        students.add(student);
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        return students.stream()
                .filter(s -> s.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Студент не знайдений"));
    }

    public boolean removeStudentById(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    @Override
    public String toString() {
        return "Group " + groupName + " Students:" + System.lineSeparator() +
                students.stream().map(Student::toString).collect(Collectors.joining(System.lineSeparator()));
    }
    public void sortStudentsByLastName() {
        students.sort(new LastNameComparator());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Group group = (Group) obj;
        return Objects.equals(groupName, group.groupName) &&
                Arrays.equals(students.toArray(new Student[0]), group.students.toArray(new Student[0]));
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(groupName);
        result = 31 * result + Arrays.hashCode(students.toArray(new Student[0]));
        return result;
    }

    public boolean areAllStudentsUnique() {
        Set<Student> studentSet = new HashSet<>(Arrays.asList(students.toArray(new Student[0])));
        return studentSet.size() == Arrays.stream(students.toArray(new Student[0])).filter(Objects::nonNull).count();
    }
}
