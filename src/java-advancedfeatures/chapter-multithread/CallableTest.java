/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable
 * JDK 5.0
 */

class NumberThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            // System.out.println(i);
            sum += i;
        }
        return sum;
    }
    
}

public class CallableTest {
    
    public static void main(String[] args) {
        NumberThread nt = new NumberThread();
        FutureTask ft = new FutureTask(nt);

        new Thread(ft).start();
        
        try {
            Object sum = ft.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
