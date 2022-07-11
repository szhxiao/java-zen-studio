/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */

class Window implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": " + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
    
}

public class WindowRunnableTest {
    
    public static void main(String[] args) {
        Window w = new Window();
        Thread wt1 = new Thread(w);
        Thread wt2 = new Thread(w);
        Thread wt3 = new Thread(w);

        wt1.setName("Window1");
        wt2.setName("Window2");
        wt3.setName("Window3");

        wt1.start();
        wt2.start();
        wt3.start();
    }    
}
