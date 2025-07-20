import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Select option: ");
            int choice;

            // Handle non-integer user input
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: {
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Age: ");
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Course: ");
                        String course = scanner.nextLine().trim();
                        manager.addStudent(new Student(id, name, age, course));
                        System.out.println("Student added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please enter valid numbers for ID and Age.");
                    }
                    break;
                }
                case 2:
                    manager.listStudents();
                    break;
                case 3: {
                    System.out.print("Enter ID to update: ");
                    int uid;
                    try {
                        uid = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID input.");
                        break;
                    }
                    Student existing = manager.findStudent(uid);
                    if (existing == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("New Name: ");
                    String uname = scanner.nextLine().trim();
                    System.out.print("New Age: ");
                    int uage;
                    try {
                        uage = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age input.");
                        break;
                    }
                    System.out.print("New Course: ");
                    String ucourse = scanner.nextLine().trim();
                    if (manager.updateStudent(uid, uname, uage, ucourse))
                        System.out.println("Updated successfully.");
                    else
                        System.out.println("Student not found.");
                    break;
                }
                case 4: {
                    System.out.print("Enter ID to delete: ");
                    int did;
                    try {
                        did = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID input.");
                        break;
                    }
                    if (manager.deleteStudent(did))
                        System.out.println("Deleted successfully.");
                    else
                        System.out.println("Student not found.");
                    break;
                }
                case 5:
                    manager.saveToFile();
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
