package it.prog;

class Some implements Runnable {
    public static int temp = 0;
    public static final int N = 10_000_000;

    public synchronized static void inc(){
        temp++;
    }

    @Override
    public void run() {
        for (int i = 0; i < N; i++){
            inc();
        }
    }
}

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        Thread newOne = new Thread (new Some());
        Thread newTwo = new Thread (new Some());
        newOne.start();
        newTwo.start();

        newOne.join();
        newTwo.join();

        System.out.println(Some.temp);
    }
}
