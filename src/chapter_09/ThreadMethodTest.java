/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */

class PrimeThread extends Thread {

    public PrimeThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }

            // if (i % 20 == 0) {
            //     this.yield();
            // }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        PrimeThread pt = new PrimeThread("PrimeThread");

        // pt.setName("PrimeThread");
        pt.start();

        Thread.currentThread().setName("MainThread");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
            if (i == 20) {
                try {
                    pt.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
