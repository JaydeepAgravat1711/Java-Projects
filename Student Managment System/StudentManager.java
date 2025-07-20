import java.io.*;
import java.util.*;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private final String filename = "students.txt";

    public void loadFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No data file found, starting fresh.");
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save data: " + e.getMessage());
        }
    }

    // CRUD METHODS

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println("ID: " + s.getId() +
                                   ", Name: " + s.getName() +
                                   ", Age: " + s.getAge() +
                                   ", Course: " + s.getCourse());
            }
        }
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public boolean updateStudent(int id, String name, int age, String course) {
        Student s = findStudent(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            saveToFile();
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Student s = findStudent(id);
        if (s != null) {
            students.remove(s);
            saveToFile();
            return true;
        }
        return false;
    }
}
