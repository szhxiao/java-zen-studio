/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import transaction.config.AppConfig;
import transaction.service.AccountService;

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
                new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService = context.getBean("accountService",
                AccountService.class);
        accountService.transferAccount();
    }
}
