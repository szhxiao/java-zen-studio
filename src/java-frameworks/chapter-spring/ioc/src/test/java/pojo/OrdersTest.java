/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package pojo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Order;

public class OrdersTest {
    @Test
    public void testOrders() {
        // 1. 加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // 2. 获取配置创建的对象
        Order order = context.getBean("order", Order.class);

        System.out.println("步骤4：获取创建的Bean实例对象");
        System.out.println(order);

        ((ClassPathXmlApplicationContext)context).close();
    }
}
