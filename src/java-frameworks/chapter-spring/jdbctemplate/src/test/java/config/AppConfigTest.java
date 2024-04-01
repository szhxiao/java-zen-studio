/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package config;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppConfigTest {
    private ApplicationContext context;
    @BeforeAll
    public void getApplicationContext() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void testUser() {
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

}
