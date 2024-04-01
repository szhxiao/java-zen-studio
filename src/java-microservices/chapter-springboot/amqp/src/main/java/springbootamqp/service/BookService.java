/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootamqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import springbootamqp.pojo.Book;

@Service
public class BookService {

    @RabbitListener(queues = "yaoguang.news")
    public void receive(Book book) {
        System.out.println("Get message: " + book);
    }

    @RabbitListener(queues = "kunlun")
    public void receiveMessage(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
