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


public class EmployeeTest {
    @Test
    public void testUser() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }
}
