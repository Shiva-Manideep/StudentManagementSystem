import service.StudentService;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentService service = new StudentService();
        service.loadFromFile();

        boolean exit = false;

        while (!exit) {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    service.addStudentInteractive(scanner);
                    break;
                case "2":
                    service.updateStudentInteractive(scanner);
                    break;
                case "3":
                    service.deleteStudentInteractive(scanner);
                    break;
                case "4":
                    service.searchStudentInteractive(scanner);
                    break;
                case "5":
                    service.listStudents();
                    break;
                case "0":
                    service.saveToFile();
                    exit = true;
                    System.out.println("Exiting... Data saved.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Search Student by ID");
        System.out.println("5. List All Students");
        System.out.println("0. Exit");
        System.out.println("=====================================");
    }
}