package it.prog;

class Some implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(i);
        }
    }
}

public class Starter {
    public static void main(String[] args) {
        Thread newOne = new Thread (new Some());
        Thread newTwo = new Thread (new Some());
        newOne.start();
        newTwo.start();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(750);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(i);
            }
        });
        t1.start();
    }
}
