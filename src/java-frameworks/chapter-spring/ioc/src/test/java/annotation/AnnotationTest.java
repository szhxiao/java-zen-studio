 /**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package annotation;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.User;


public class AnnotationTest {
    @Test
    public void testUser() {
        // 1. 加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans-annotation.xml");

        // 2. 获取配置创建的对象
        User user = context.getBean("user", User.class);

        System.out.println(user);
    }
}
