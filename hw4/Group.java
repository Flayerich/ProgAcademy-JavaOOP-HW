package hw4;

import java.util.Arrays;

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
				if (students[i].getLastName().equals(lastName) {
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
	    Arrays.sort(students, Comparator.nullLast(new LastNameComparator());
	}
}
