/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootamqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit           // 开启基于注解的RabbitMQ
@SpringBootApplication
public class SpringBootAmqpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class);
    }
}
