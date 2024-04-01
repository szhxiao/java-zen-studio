/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {
    @Test
    public void testHelloSpring() {
        // 1. 加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // 2. 获取配置创建的对象
        HelloSpring hello = context.getBean("hello", HelloSpring.class);

        System.out.println(hello);
        hello.show();
    }
}
