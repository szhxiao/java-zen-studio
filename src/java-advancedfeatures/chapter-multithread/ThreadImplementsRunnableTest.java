/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Create a new thread.
 * 
 * Declare a class that implements the Runnable interface. 
 * That class then implements the run method. 
 * An instance of the class can then be allocated, 
 * passed as an argument when creating Thread, and started.
 */

class PrimeRun implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadImplementsRunnableTest {
    public static void main(String[] args) {
        PrimeRun p = new PrimeRun();
        Thread tp = new Thread(p);
        tp.start();
    }
}
