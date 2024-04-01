/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springboottask.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    // 标明为异步方法
    @Async
    public void hello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("处理数据中...");
    }
}
