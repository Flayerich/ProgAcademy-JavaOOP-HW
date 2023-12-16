package hw_10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    private static final String DICTIONARY_FILE = "dictionary.txt";

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        loadDictionary(dictionary);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Добавити слово у словник.");
            System.out.println("2. Перевести слово.");
            System.out.println("3. Показати повністю словник.");
            System.out.println("4. Зберегти і вийти.");
            System.out.print("Виберіть дію: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addWordToDictionary(scanner, dictionary);
                    break;
                case 2:
                    translateWord(scanner, dictionary);
                    break;
                case 3:
                    showDictionary(dictionary);
                    break;
                case 4:
                    saveDictionary(dictionary);
                    break;
                default:
                    System.out.println("Невірний вибір. Введіть знову.");
            }

        } while (choice != 4);
    }

    private static void addWordToDictionary(Scanner scanner, Map<String, String> dictionary) {
        System.out.print("Введіть слово на англійській мові: ");
        String englishWord = scanner.nextLine().toLowerCase();

        System.out.print("Введіть слово на українській мові: ");
        String ukrainianTranslation = scanner.nextLine();

        dictionary.put(englishWord, ukrainianTranslation);
        System.out.println("Слово успішно додано у словник.");
    }

    private static void translateWord(Scanner scanner, Map<String, String> dictionary) {
        System.out.print("Введіть слово на англійській мові для перекладу. ");
        String wordToTranslate = scanner.nextLine().toLowerCase();

        if (dictionary.containsKey(wordToTranslate)) {
            System.out.println("Переклад: " + dictionary.get(wordToTranslate));
        } else {
            System.out.println("Переклад не знайдено.");
        }
    }

    private static void showDictionary(Map<String, String> dictionary) {
        System.out.println("Словник:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static void saveDictionary(Map<String, String> dictionary) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DICTIONARY_FILE))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.println(entry.getKey() + ":" + entry.getValue());
            }
            System.out.println("Словник успішно збережено у файл: " + DICTIONARY_FILE);
        } catch (IOException e) {
            System.out.println("Помилка при збереженні словника: " + e.getMessage());
        }
    }

    private static void loadDictionary(Map<String, String> dictionary) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    dictionary.put(parts[0].toLowerCase(), parts[1]);
                }
            }
            System.out.println("Словник успішно загружений з файлу: " + DICTIONARY_FILE);
        } catch (IOException e) {
            System.out.println("Файл словника не знайдено. Створений новий словник.");
        }
    }
}
