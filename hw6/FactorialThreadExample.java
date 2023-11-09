package hw6;

import java.math.BigInteger;

public class FactorialThreadExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            Thread thread = new Thread(new FactorialTask(i));
            thread.start();
        }
    }
}

class FactorialTask implements Runnable {
    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("Факторіал числа %d дорівнює %s%n", number, factorial);
    }
}


