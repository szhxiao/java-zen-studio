 /**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.example.SpringConfig;
import org.example.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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

    @Test
    public void testAnnotation() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        User user = context.getBean("user", User.class);

        System.out.println(user);
    }
}
