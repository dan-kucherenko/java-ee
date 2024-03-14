package ua.ukma.lab4;

import java.util.ArrayList;

public class ElementRemoving {
    public static void main(String[] args) {
        ArrayList<Double> al = new ArrayList<>();
        al.add(5.0);
        al.add(4.0);
        al.add(3.0);
        al.add(2.0);
        al.add(1.0);
        al.remove(Double.valueOf(4));
        System.out.println(al);
    }
}
