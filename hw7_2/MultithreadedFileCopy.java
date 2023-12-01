package hw7_2;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class MultithreadedFileCopy {

    public static void main(String[] args) {
        String sourcePath = "/Users/flayerich/Downloads/JavaProgAcademy/Test1/test1.pdf"; // Замініть на шлях до вашого файлу
        String destPath = "/Users/flayerich/Downloads/JavaProgAcademy/Test2/test1.pdf"; // Замініть на шлях, куди копіювати
        int threadCount = 5; // Кількість потоків
        long fileSize = new File(sourcePath).length();
        long blockSize = fileSize / threadCount;

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        AtomicLong progress = new AtomicLong(0);

        for (int i = 0; i < threadCount; i++) {
            long start = i * blockSize;
            long end = (i + 1) == threadCount ? fileSize : start + blockSize;

            executor.submit(() -> {
                try {
                    copyBlock(sourcePath, destPath, start, end, progress, fileSize);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }

    private static void copyBlock(String sourcePath, String destPath, long start, long end, AtomicLong progress, long totalSize) throws IOException {
        try (RandomAccessFile sourceFile = new RandomAccessFile(sourcePath, "r");
             RandomAccessFile destFile = new RandomAccessFile(destPath, "rw")) {
            sourceFile.seek(start);
            destFile.seek(start);
            byte[] buffer = new byte[1024];
            long position = start;

            while (position < end) {
                int bytesToRead = (int) Math.min(buffer.length, end - position);
                sourceFile.readFully(buffer, 0, bytesToRead);
                destFile.write(buffer, 0, bytesToRead);
                position += bytesToRead;

                // Оновлення прогресу
                synchronized (progress) {
                    progress.addAndGet(bytesToRead);
                    double percentCompleted = 100.0 * progress.get() / totalSize;
                    System.out.println("Прогрес копіювання: " + percentCompleted + "%");
                }
            }
        }
    }
}
