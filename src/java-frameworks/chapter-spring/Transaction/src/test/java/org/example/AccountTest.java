/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.example.config.AnnotationConfig;
import org.example.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AccountTest {
    @Test
    public void testTransferAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");
        AccountService accountService = context.getBean("accountService",
                AccountService.class);
        accountService.transferAccount();
    }

    @Test
    public void testAnnotationTransferAccount() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AccountService accountService = context.getBean("accountService",
                AccountService.class);
        accountService.transferAccount();
    }
}
