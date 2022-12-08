/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package restful.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import restful.pojo.User;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    private ApplicationContext context;
    private UserService userService;
    @BeforeAll
    public void getApplicationContext() {
        // context = new AnnotationConfigApplicationContext(AppConfig.class);
        context = new ClassPathXmlApplicationContext("springmvc.xml");
        userService = context.getBean("userService", UserService.class);
    }

    @Test
    public void testSaveUser() {
        User user = new User("史铁生", "ok","tiesheng@126.com");
        userService.saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(2, "老舍", "ok","laoshe@163.com");
        userService.updateUser(user);
    }

    @Test
    public void testRemoveUser() {
        userService.removeUser(1);
    }

    @Test
    public void testGetUserById() {
        User user = userService.getUserById(3);
        System.out.println(user);
    }

    @Test
    public void testGetUserCount() {
        int count = userService.getUserCount();
        System.out.println("User count: " + count);
    }

    @Test
    public void testGetAllUsers(){
        List<User> userList = userService.getAllUsers();
        System.out.println(userList);
    }

    @Test
    public void testBatchSaveUsers() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"鲁迅", "ok", "luxun@hongyan.com"};
        Object[] o2 = {"矛盾", "ok", "maodun@126.com"};
        Object[] o3 = {"贾平凹", "ok", "pingwa@qq.com"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        userService.batchSaveUsers(batchArgs);
    }

    /*
    @Test
    public void testBatchUpdateUsers() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {5, "鲁迅", "luxun", "luxun@hongyan.com"};
        Object[] o2 = {6, "刘震云", "yun", "zhenyun@126.com"};
        Object[] o3 = {7, "贾平凹", "pingwa", "pingwa@qq.com"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        userService.batchUpdateUsers(batchArgs);
    }
    */

    @Test
    public void testBatchRemoveUsers() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {5};
        Object[] o2 = {7};
        batchArgs.add(o1);
        batchArgs.add(o2);
        // userService.batchRemoveUsers(batchArgs);
    }
}
