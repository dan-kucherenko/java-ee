package ua.ukma.kucherenko;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You should type in the name of the file to parse!");
            return;
        }
        String filePath =  args[0];
        Dictionary dictionary = new Dictionary();
        dictionary.createDictionary(filePath);
        System.out.println("Word Frequencies:\n" + dictionary.getWordFrequencies());
    }
}
