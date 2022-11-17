package org.example; /**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrdersTest {
    @Test
    public void testOrders() {
        // 1. 加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // 2. 获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println("步骤4：获取创建的Bean实例对象");
        System.out.println(orders);

        ((ClassPathXmlApplicationContext)context).close();
    }
}
