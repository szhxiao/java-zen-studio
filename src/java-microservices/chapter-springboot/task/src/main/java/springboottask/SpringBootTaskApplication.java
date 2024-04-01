/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springboottask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// 开启异步注解
@EnableAsync
// 开启基于注解的定时任务
@EnableScheduling
@SpringBootApplication
public class SpringBootTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskApplication.class);
    }
}
