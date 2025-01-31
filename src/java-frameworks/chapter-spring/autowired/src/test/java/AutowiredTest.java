/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;

public class AutowiredTest {
    @Test
    public void testAutowired() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        person.getCat().shout();
        person.getDog().shout();
        System.out.println(person);
    }
}
