/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package config;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.User;

public class AppConfigTest {
    @Test
    public void testAppConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
