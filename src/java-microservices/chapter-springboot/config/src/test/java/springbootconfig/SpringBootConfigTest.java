/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springbootconfig.pojo.Person;

@SpringBootTest
public class SpringBootConfigTest {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

    @Test
    public void testHelloService() {
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }
}
