package hw6;

import java.util.concurrent.atomic.AtomicLong;

public class Summation {

    public static void main(String[] args) {
        final int SIZE = 10_000_000;
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = 1; // Заповнюємо масив для спрощення, кожен елемент має значення 1
        }

        // Однопоточний підрахунок
        long startTime = System.nanoTime();
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        long endTime = System.nanoTime();
        System.out.println("Однопоточний результат: " + sum);
        System.out.println("Однопоточний час: " + (endTime - startTime) + " ns");

        // Багатопоточний підрахунок
        final int THREAD_COUNT = 4;
        AtomicLong multiThreadSum = new AtomicLong(0);
        Thread[] threads = new Thread[THREAD_COUNT];

        startTime = System.nanoTime();
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * (SIZE / THREAD_COUNT);
            final int end = (i + 1) * (SIZE / THREAD_COUNT);
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    multiThreadSum.addAndGet(numbers[j]);
                }
            });
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join(); // Чекаємо завершення всіх потоків
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();

        System.out.println("Багатопоточний результат: " + multiThreadSum);
        System.out.println("Багатопоточний час: " + (endTime - startTime) + " ns");
    }
}

