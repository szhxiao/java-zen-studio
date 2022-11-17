package org.example; /**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void testStudent() {
        // 1. 加载配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        // 2. 获取配置创建的对象
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }
}
