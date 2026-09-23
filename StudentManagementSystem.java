import java.util.Scanner;

public class StudentManagementSystem {

    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    updateStudent(sc);
                    break;

                case 5:
                    deleteStudent(sc);
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students[count] = new Student(id, name, age, course);
        count++;

        System.out.println("Student added successfully!");
    }

    static void displayStudents() {

        if (count == 0) {
            System.out.println("No students found!");
            return;
        }

        for (int i = 0; i < count; i++) {
            students[i].displayStudent();
        }
    }

    static void searchStudent(Scanner sc) {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (students[i].id == id) {
                students[i].displayStudent();
                return;
            }
        }

        System.out.println("Student not found!");
    }

    static void updateStudent(Scanner sc) {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (students[i].id == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                students[i].name = sc.nextLine();

                System.out.print("Enter new age: ");
                students[i].age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter new course: ");
                students[i].course = sc.nextLine();

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    static void deleteStudent(Scanner sc) {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (students[i].id == id) {

                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[count - 1] = null;
                count--;

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}