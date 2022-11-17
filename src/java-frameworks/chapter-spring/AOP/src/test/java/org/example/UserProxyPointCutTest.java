/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.example.annotation.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class UserProxyPointCutTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAspectJAnnotation() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans-aspect.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
