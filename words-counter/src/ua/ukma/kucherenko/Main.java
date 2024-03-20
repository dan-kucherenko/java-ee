package ua.ukma.kucherenko;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        Dictionary dictionary = new Dictionary();
        dictionary.createDictionary(filePath);
        System.out.println("Word Frequencies:\n" + dictionary.getWordFrequencies());
    }
}
