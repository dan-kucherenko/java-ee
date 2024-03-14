package ua.ukma.kucherenko;

import java.util.ArrayList;

public class CsvParser {
    public static final CsvParser shared = new CsvParser();
    private CsvParser(){}
    public Student fromCsvRow(String row) {
        String[] fields = row.split(";");
        String name = fields[0];
        ArrayList<Integer> grades = new ArrayList<>();
        for (int i = 1; i < fields.length; i++) {
            grades.add(Integer.parseInt(fields[i]));
        }
        return new Student(name, grades);
    }
}
