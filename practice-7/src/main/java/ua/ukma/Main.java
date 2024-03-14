package ua.ukma;

import ua.ukma.lab1.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", new ArrayList<>(List.of(90, 85, 88))));
        students.add(new Student("Alice", new ArrayList<>(List.of(80, 75, 78))));
        students.add(new Student("Bob", new ArrayList<>(List.of(85, 90, 82))));

        // Сортування за спаданням середнього рейтингу за допомогою явної реалізації Comparator анонімним класом
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getAverageRating(), s1.getAverageRating());
            }
        });

        System.out.println("Сортування за спаданням середнього рейтингу (явна реалізація інтерфейсу Comparator анонімним класом):");
        for (Student student : students) {
            System.out.println(student);
        }

        // Сортування за спаданням середнього рейтингу за допомогою лямбда-виразів
        students.sort((s1, s2) -> Double.compare(s2.getAverageRating(), s1.getAverageRating()));

        System.out.println("\nСортування за спаданням середнього рейтингу (використання лямбда-виразів):");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
