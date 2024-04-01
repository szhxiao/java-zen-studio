/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package service;

import config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceProxyTest {
    @Test
    public void testAspectJAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.add();
    }
}
