/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package log;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogTest {
    private ApplicationContext context;
    @BeforeAll
    public void getApplicationContext() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testLogPointCut() {
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        userService.add();
        userService.update();
    }
}
