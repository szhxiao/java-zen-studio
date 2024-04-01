/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootjdbc.dao.UserMapper;
import springbootjdbc.pojo.User;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        // System.out.println("id = " + id);
        return userMapper.getUserById(id);
    }

    @GetMapping("/user")
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
