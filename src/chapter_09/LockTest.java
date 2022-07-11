/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock
 */

class Window implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println(Thread.currentThread().getName() 
                        + ": ticket-" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
