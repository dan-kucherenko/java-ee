package ua.ukma.kucherenko;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        final String csvFile = "src/ua/ukma/kucherenko/students.csv";
        final ArrayList<Student> students = parseCsv(csvFile);

        Collections.sort(students);

        StringBuilder sb = new StringBuilder();
        students.forEach(student -> sb.append(student.getName())
                .append(" - ")
                .append(student.getGrades())
                .append(" - ")
                .append(student.getAverageRating())
                .append('\n'));

        System.out.println("Parsed students with grades:\n" + sb);
    }

    private static ArrayList<Student> parseCsv(String filePath) {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String row;
            while ((row = br.readLine()) != null) {
                students.add(CsvParser.shared.fromCsvRow(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
