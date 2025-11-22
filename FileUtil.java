package util;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    private static final String FILE_NAME = "students.dat";

    @SuppressWarnings("unchecked")
    public static List<Student> readStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                return (List<Student>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not read students from file: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void writeStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Could not save students to file: " + e.getMessage());
        }
    }
}