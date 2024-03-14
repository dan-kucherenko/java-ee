package ua.ukma.kucherenko;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private final String name;
    private final ArrayList<Integer> grades;

    public Student(String name, ArrayList<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageRating() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getAverageRating(), this.getAverageRating());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
