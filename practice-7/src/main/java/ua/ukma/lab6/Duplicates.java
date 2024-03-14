package ua.ukma.lab6;

import java.util.Comparator;
import java.util.TreeSet;

public class Duplicates {
    public static void main(String[] args) {
        // Create a custom comparator that considers elements equal if their values are equal
        Comparator<Integer> customComparator = (i1, i2) -> System.identityHashCode(i1) - System.identityHashCode(i2);;

        // Create a TreeSet<Integer> with the custom comparator
        TreeSet<Integer> treeSetWithDuplicates = new TreeSet<>(customComparator);

        // Add elements to the TreeSet
        treeSetWithDuplicates.add(5);
        treeSetWithDuplicates.add(2);
        treeSetWithDuplicates.add(7);
        treeSetWithDuplicates.add(5); // Adding a duplicate element

        // Print the elements in the TreeSet
        System.out.println("TreeSet with duplicate elements: " + treeSetWithDuplicates);
    }
}
