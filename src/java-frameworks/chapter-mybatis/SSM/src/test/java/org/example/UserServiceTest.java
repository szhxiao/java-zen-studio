/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example;

import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceTest {

    @Test
    public void testGetAllUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        List<User> userList = userService.getUsers();
        userList.forEach(System.out::println);
    }
}
