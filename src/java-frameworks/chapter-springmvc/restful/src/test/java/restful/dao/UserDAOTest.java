/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package restful.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import restful.pojo.User;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserDAOTest {
    private ApplicationContext context;
    private UserDAO userDAO;
    @BeforeAll
    public void getApplicationContext() {
        // context = new AnnotationConfigApplicationContext(AppConfig.class);
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDAO = context.getBean("userDAO", UserDAOImpl.class);
    }

    @Test
    public void testSaveUser() {
        User user = new User("莫言", "ok","moyan@126.com");
        userDAO.saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(3, "余华", "ok","yuhua@163.com");
        userDAO.updateUser(user);
    }

    @Test
    public void testRemoveUser() {
        userDAO.removeUser(1);
    }

    @Test
    public void testGetUserById() {
        User user = userDAO.getUserById(3);
        System.out.println(user);
    }

    @Test
    public void testGetUserCount() {
        int count = userDAO.getUserCount();
        System.out.println("User count: " + count);
    }

    @Test
    public void testGetAllUsers(){
        List<User> userList = userDAO.getAllUsers();
        System.out.println(userList);
    }

    @Test
    public void testBatchSaveUsers() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"鲁迅", "ok", "luxun@hongyan.com"};
        Object[] o2 = {"刘震云", "ok", "zhenyun@126.com"};
        Object[] o3 = {"贾平凹", "ok", "pingwa@qq.com"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        userDAO.batchSaveUsers(batchArgs);
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
        userDAO.batchUpdateUsers(batchArgs);
    }
    */

    @Test
    public void testBatchRemoveUsers() {
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {5};
        Object[] o2 = {7};
        batchArgs.add(o1);
        batchArgs.add(o2);
        // userDAO.batchRemoveUsers(batchArgs);
    }
}
