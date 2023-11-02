package hw5;

import java.io.*;

public class CopyFiles  {

	public static void main(String[] args) {
        File sourceDirectory = new File("/Users/flayerich/Downloads/JavaProgAcademy");
        File destinationDirectory = new File("/Users/flayerich/Downloads/JavaProgAcademy/Videos");

        // Перевірка, чи існують директорії
        if (!sourceDirectory.exists() || !sourceDirectory.isDirectory() || !destinationDirectory.exists()) {
            System.out.println("Невірний шлях до директорії.");
            return;
        }

        // Отримуємо список файлів з розширенням .pdf в директорії

        File[] pdfFiles = sourceDirectory.listFiles(new PdfFileFilter());
        if (pdfFiles != null) {
            for (File file : pdfFiles) {
                try (InputStream is = new FileInputStream(file);
                     OutputStream os = new FileOutputStream(new File(destinationDirectory, file.getName()))) {

                    byte[] bytes = new byte[5000];
                    int bytesRead;
                    while ((bytesRead = is.read(bytes)) != -1) {
                        os.write(bytes, 0, bytesRead);
                    }

                    System.out.println("Файл " + file.getName() + " скопійовано до " + destinationDirectory.getPath());
                } catch (IOException e) {
                    System.out.println("Помилка копіювання файлу " + file.getName() + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("Немає файлів типу PDF в вихідній директорії.");
        }
    }
}

