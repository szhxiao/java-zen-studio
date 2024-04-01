/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.yaoguang.restfulcrud.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yaoguang.restfulcrud.pojo.User;

import java.util.List;

@SpringBootTest
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

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

}
