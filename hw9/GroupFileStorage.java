package hw9;

import hw9.Human.Gender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class GroupFileStorage {
    public void saveGroupToCSV(Group gr, String fileName) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : gr.getStudents()) {
                if (student != null) {
                    writer.println(student.getName() + "," + student.getLastName() + "," + student.getGender() + ","
                            + student.getId() + "," + student.getGroupName());
                }
            }
            System.out.println("Група збережена у файл " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }

    public File findFileByGroupName(String groupName, File workFolder) {
        File[] files = workFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(groupName)) {
                    return file;
                }
            }
        }
        return null;
    }
    public Group loadGroupFromCSV(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        List<Student> students = new ArrayList<>();
        String fileNameWithoutExtension = file.getName().replaceFirst("[.][^.]+$", "");
        Group group = new Group(fileNameWithoutExtension);

        for (String line : lines) {
            String[] parts = line.split(","); // Припустимо, що дані у файлі розділені комою

            String name = parts[0].trim();
            String lastName = parts[1].trim();
            Gender gender = Gender.valueOf(parts[2].trim().toUpperCase());
            int id = Integer.parseInt(parts[3].trim());
            String groupName = parts[4].trim();

            Student student = new Student(name, lastName, gender, id, groupName);
            students.add(student);

            // Вивести інформацію про студента в консоль
            System.out.println(student.toString());
        }
        group.setStudents(students);
        return group;
    }

}
