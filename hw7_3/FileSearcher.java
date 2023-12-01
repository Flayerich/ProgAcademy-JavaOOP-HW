package hw7_3;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class FileSearcher implements Runnable {

    private final String fileNameToSearch;
    private final File directory;
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final AtomicInteger activeSearchTasks = new AtomicInteger(0);

    public FileSearcher(String fileNameToSearch, File directory) {
        this.fileNameToSearch = fileNameToSearch;
        this.directory = directory;
    }

    @Override
    public  void run() {
        activeSearchTasks.incrementAndGet();
        try {
            search(directory);
        } finally {
            if (activeSearchTasks.decrementAndGet() == 0) {
                executor.shutdown();
                try {
                    executor.awaitTermination(4, TimeUnit.SECONDS); //найменше значення часу 4 секунди. Якщо 3 сек і менше то
                    System.out.println("Пошук завершено.");                     // System.out.println("Пошук завершено.")
                } catch (InterruptedException e) {                              //   може виводитись декілька разів підряд
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void search(File directory) {
        if (directory.isDirectory()) {
            File[] subDirectories = directory.listFiles();
            if (subDirectories != null) {
                for (File file : subDirectories) {
                    if (file.isDirectory()) {
                        executor.execute(new FileSearcher(fileNameToSearch, file));
                    } else {
                        if (file.getName().equals(fileNameToSearch)) {
                            System.out.println("Файл знайдено: " + file.getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String fileNameToSearch = "test1.pdf";
        File rootDirectory = new File("/Users/flayerich/Downloads");
        executor.execute(new FileSearcher(fileNameToSearch, rootDirectory));
    }
}
