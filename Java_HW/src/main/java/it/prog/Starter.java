package it.prog;

class Some implements Runnable {
    public static int temp = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            temp++;
            System.out.println(temp);
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
                Some.temp++;
                System.out.print(Some.temp);
            }
        });
        t1.start();
    }
}
