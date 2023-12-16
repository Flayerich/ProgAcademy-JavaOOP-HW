package hw_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;


public class LettersAnalizer {
    public static void main(String[] args) {
        try {
            // Зчитуємо текст з файлу
            String text = readTextFromFile("/Users/flayerich/IdeaProjects/HWoop/HW_OOP/src/hw_10/sample.txt");

            // Визначаємо частоту повторення кожної букви
            Map<Character, Long> letterFrequencies = calculateLetterFrequencies(text);

            // Виводимо результат у порядку зменшення частоти повторення
            letterFrequencies.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTextFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static Map<Character, Long> calculateLetterFrequencies(String text) {
        return text.codePoints()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));
    }
}
