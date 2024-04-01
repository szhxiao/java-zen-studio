/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

/**
 * Create a new thread to ergodic numbers less than 100
 */

public class ErgodicNumbers {
    
    public static void main(String[] args) {
        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();
    }    

}
