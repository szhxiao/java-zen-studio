/**
 * java-zen-studio
 * 
 * @author szhxiao
 * @version 1st
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread pool
 */

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPoolTest {
    
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        
        // 2. 执行指定的线程操作，需要提供Runnable接口或Callable接口实现类对象
        // 适用于Runnable
        service.execute(new NumberThread());
        // 适用于Callable
        // service.submit();

        // 3. 关闭线程池
        service.shutdown();
    }
}
