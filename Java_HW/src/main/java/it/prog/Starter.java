package it.prog;

import static java.lang.Math.sin;

public class Starter {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(50 * finalI);
                        System.out.println(sin(j));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }).start();
        }
    }
}
