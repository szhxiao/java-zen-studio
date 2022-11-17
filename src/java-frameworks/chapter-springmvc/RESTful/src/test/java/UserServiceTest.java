/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

import org.example.pojo.User;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class UserServiceTest {
    @Test
    public void testSaveUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        User user = new User("王德峰","wdf1234", "中国上海", "13345671234");
        userService.saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        User user = new User(6, "王德峰","ok", "中国上海", "13345670000");
        userService.updateUser(user);
    }

    @Test
    public void testRemoveUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        userService.removeUser(6);
    }

    @Test
    public void testGetUserCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        int count = userService.getUserCount();
        System.out.println(count + " items in table user");
    }

    @Test
    public void testGetUserById() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.getUserById(4);
        System.out.println(user);
    }

    @Test
    public void testGetAllUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testBatchSaveUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"莫言", "ok", "ShanDong", "13212345678"};
        Object[] o2 = {"余华", "ok", "ShanDong", "13212345678"};
        Object[] o3 = {"贾平凹", "ok", "ShanXi", "13212345678"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        userService.batchSaveUsers(batchArgs);
    }

    @Test
    public void testBatchUpdateUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"矛盾", "ok", "ShanDong", "13212345678", 12};
        Object[] o2 = {"老舍", "ok", "Beijing", "13212345678", 13};
        Object[] o3 = {"余秋雨", "ok", "ShanXi", "13212345678", 14};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        userService.batchUpdateUsers(batchArgs);
    }

    @Test
    public void testBatchRemoveUsers() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springmvc.xml");
        UserService userService = context.getBean("userService",
                UserService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {5};
        Object[] o2 = {15};
        batchArgs.add(o1);
        batchArgs.add(o2);
        userService.batchRemoveUsers(batchArgs);
    }
}
