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

    // 同步方式一
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步方式一
            // synchronized(obj) {
            // 同步方式二
            synchronized(Window.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
    
}

public class ThreadSynchronizedBlockTest {
    
    public static void main(String[] args) {
        Window w1 = new Window("Window1");
        Window w2 = new Window("Window2");
        Window w3 = new Window("Window3");

        w1.start();
        w2.start();
        w3.start();

    }    
}
