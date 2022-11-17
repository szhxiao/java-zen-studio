/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * 
 */

public class DeadLockTest {
    
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized(s1) {
                    s1.append("hello ");
                    s2.append("world ");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(s2) {
                        s1.append("java ");
                        s2.append("python ");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
            
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(s2) {
                    s1.append("reading ");
                    s2.append("writing ");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    synchronized(s1) {
                        s1.append("books ");
                        s2.append("articles ");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }    
}
