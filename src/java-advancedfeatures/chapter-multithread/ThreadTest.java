/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Create a new thread.
 * 
 * Declare a class to be a subclass of Thread
 * This subclass should override the run method of class Thread
 * An instance of the subclass can then be allocated and started
 */

class PrimeThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
    
}

public class ThreadTest {
    
    public static void main(String[] args) {
        PrimeThread pt = new MyThread();
        // Causes this thread to begin execution; 
        // the Java Virtual Machine calls the run method of this thread
        pt.start();

        // can not calls new thread by run()
        // mt.run();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }    
}
