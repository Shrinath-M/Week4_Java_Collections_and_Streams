import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        String filePath = "input.txt";
        Map<String, Integer> wordFrequencies = countWordFrequency(filePath);
        System.out.println("Word Frequency Map: " + wordFrequencies);
    }
}
