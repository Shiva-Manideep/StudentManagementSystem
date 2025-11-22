package service;

import model.Student;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void loadFromFile() {
        students = FileUtil.readStudents();
        System.out.println("Loaded " + students.size() + " students from file.");
    }

    public void saveToFile() {
        FileUtil.writeStudents(students);
    }

    public void addStudentInteractive(Scanner scanner) {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (findById(id).isPresent()) {
                System.out.println("A student with this ID already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            System.out.print("Enter Grade: ");
            String grade = scanner.nextLine();

            Student student = new Student(id, name, age, course, grade);
            students.add(student);
            System.out.println("Student added successfully.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number input. Please try again.");
        }
    }

    public void updateStudentInteractive(Scanner scanner) {
        try {
            System.out.print("Enter ID of student to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            Optional<Student> opt = findById(id);
            if (!opt.isPresent()) {
                System.out.println("Student not found.");
                return;
            }

            Student s = opt.get();
            System.out.println("Leave a field empty to keep the current value.");

            System.out.print("Enter new name (" + s.getName() + "): ");
            String name = scanner.nextLine();
            if (!name.trim().isEmpty()) {
                s.setName(name);
            }

            System.out.print("Enter new age (" + s.getAge() + "): ");
            String ageStr = scanner.nextLine();
            if (!ageStr.trim().isEmpty()) {
                s.setAge(Integer.parseInt(ageStr));
            }

            System.out.print("Enter new course (" + s.getCourse() + "): ");
            String course = scanner.nextLine();
            if (!course.trim().isEmpty()) {
                s.setCourse(course);
            }

            System.out.print("Enter new grade (" + s.getGrade() + "): ");
            String grade = scanner.nextLine();
            if (!grade.trim().isEmpty()) {
                s.setGrade(grade);
            }

            System.out.println("Student updated successfully.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void deleteStudentInteractive(Scanner scanner) {
        try {
            System.out.print("Enter ID of student to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Optional<Student> opt = findById(id);
            if (!opt.isPresent()) {
                System.out.println("Student not found.");
                return;
            }

            students.remove(opt.get());
            System.out.println("Student removed successfully.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void searchStudentInteractive(Scanner scanner) {
        try {
            System.out.print("Enter ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());

            Optional<Student> opt = findById(id);
            if (opt.isPresent()) {
                System.out.println("Student found: ");
                System.out.println(opt.get());
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("===== All Students =====");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }
}