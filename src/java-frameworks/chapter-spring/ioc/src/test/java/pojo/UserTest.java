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

public class UserTest {
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testNamespace() {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("user-bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);

    }
}
