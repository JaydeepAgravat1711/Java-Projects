Student Management System (Console-Based) 

A simple Java console-based application to manage student records. Supports CRUD (Create, Read, Update, Delete) operations with persistent storage using file I/O and an ArrayList. 

**Features** 

1. Add new student records 
1. List all students (ID, Name, Age, Course) 
1. Update student information by ID 
1. Delete students by ID 
1. Data Persistence: Student data is saved to and loaded from a local students.txt file

**How It Works** 

- Interacts with the user through a text-based menu in the console
- Uses an ArrayList to store students in memory
- Reads from and writes to students.txt for persistent storage
- Handles invalid user input gracefully 

**File Structure** 

1. Main.java // Runs the program & handles user interaction
1. Student.java // Defines the Student class
1. StudentManager.java // Manages student records and file I/O
1. students.txt // (Created automatically) Stores saved student data

**Compile the Application** 

- javac Student.java StudentManager.java Main.java

**Run the Program** 

- java Main 

**Technologies Used** 

- Java SE (Standard Edition) 
- File I/O (BufferedReader, BufferedWriter) 
- ArrayList 
