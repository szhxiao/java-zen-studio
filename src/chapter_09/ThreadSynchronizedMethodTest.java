/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */

class Window extends Thread {
    public Window() {

    }

    public Window(String name) {
        super(name);
    }

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sell();
        }
    }
    
    private static synchronized void sell() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        }
    }
}

public class ThreadSynchronizedMethodTest {
    
    public static void main(String[] args) {
        Window w1 = new Window("Window1");
        Window w2 = new Window("Window2");
        Window w3 = new Window("Window3");

        w1.start();
        w2.start();
        w3.start();

    }    
}
