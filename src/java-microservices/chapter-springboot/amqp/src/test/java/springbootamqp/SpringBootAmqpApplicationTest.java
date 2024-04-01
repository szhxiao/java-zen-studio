/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springbootamqp.pojo.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringBootAmqpApplicationTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void testExchangeSend() {
        // 需要自定义消息体内容和消息头
        // rabbitTemplate.send(exchange, routeKey, message);

        Map<String, Object> message = new HashMap<>();
        message.put("msg", "这是第一个消息");
        message.put("data", Arrays.asList("helloworld", 123));
        // rabbitTemplate.convertAndSend("exchange.direct", "yaoguang.news", message);
        rabbitTemplate.convertAndSend("exchange.direct", "yaoguang.news", new Book("长安的荔枝", "马伯庸"));
    }

    @Test
    public void testExchangeReceive() {
        Object obj = rabbitTemplate.receiveAndConvert("yaoguang.news");
        System.out.println(obj.getClass());
        System.out.println(obj);
    }

    @Test
    public void testFanoutSend() {
        rabbitTemplate.convertAndSend("exchange.fanout","", new Book("一日三秋", "刘震云"));
    }

    @Test
    public void testCreateExchange() {
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
    }

    @Test
    public void testCreateQueue() {
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));
    }

    @Test
    public void testBinding() {
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange",
                "amqpadmin.key", null));
    }
}
