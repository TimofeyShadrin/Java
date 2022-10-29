package it.prog;

class Some implements Runnable {
    public static volatile int temp = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++){
            temp++;
            //System.out.println(name + temp);
        }
    }
}

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        Thread newOne = new Thread (new Some());
        Thread newTwo = new Thread (new Some());
        newOne.start();
        newTwo.start();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++){
                Some.temp++;
                //System.out.println("main: " + Some.temp);
            }
        });
        t1.start();

        newOne.join();
        newTwo.join();
        t1.join();

        System.out.println(Some.temp);

    }
}
