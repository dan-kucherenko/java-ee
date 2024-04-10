package ua.ukma.kucherenko;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, Integer> wordCountMap;

    public Dictionary() {
        this.wordCountMap = new HashMap<>();
    }

    public void createDictionary(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split("\\W+");
                for (String word : wordsInLine) {
                    // Remove unnecessary symbols from the word
                    word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
                    word = word.toLowerCase();
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            System.out.println("Dictionary for " + filePath + " has been created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getWordFrequencies() {
        StringBuilder stringBuilder = new StringBuilder();
        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n"));
        return stringBuilder.toString();
    }
}
