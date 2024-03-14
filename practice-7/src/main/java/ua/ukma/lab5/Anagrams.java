package ua.ukma.lab5;

import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        String[] words = {"автор", "товар", "тавро", "кума", "мука", "умка", "банка", "кабан", "нитка"};

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            anagrams.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }

        for (List<String> anagramList : anagrams.values()) {
            if (anagramList.size() > 1) {
                System.out.println(anagramList);
            }
        }
    }
}
