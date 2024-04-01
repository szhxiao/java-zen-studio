/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.yaoguang.restfulcrud.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaoguang.restfulcrud.pojo.User;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

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
}
