import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String Name;
    int rollnum;
    private String grade;

    public Student(String Name, int rollnum, String grade) {
        this.Name = Name;
        this.rollnum = rollnum;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + Name + ", Roll num: " + rollnum + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollnum) {
        students.removeIf(student -> student.rollnum == rollnum);
    }

    public Student searchStudent(int rollnum) {
        for (Student student : students) {
            if (student.rollnum == rollnum) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student Name: ");
                    String Name = scanner.nextLine();
                    System.out.print("Enter roll num: ");
                    int rollnum = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    studentSystem.addStudent(new Student(Name, rollnum, grade));
                    System.out.println("Student added !!");
                    break;

                case 2:
                    System.out.print("Enter roll num of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    studentSystem.removeStudent(rollToRemove);
                    System.out.println("Student removed !!");
                    break;

                case 3:
                    System.out.print("Enter roll num of student to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student searchedStudent = studentSystem.searchStudent(rollToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student found: " + searchedStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    List<Student> allStudents = studentSystem.getAllStudents();
                    System.out.println("All Students:");
                    for (Student student : allStudents) {
                        System.out.println(student);
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        }
    }
}