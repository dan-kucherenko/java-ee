package ua.ukma.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@ToString
public class Student implements Comparable<Student>{
    private final String name;
    private final ArrayList<Integer> grades;

    public double getAverageRating() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.getAverageRating(), this.getAverageRating());
    }
}
