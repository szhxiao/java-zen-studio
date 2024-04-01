/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootcache.pojo.User;
import springbootcache.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/user")
    public User updateUser(User user) {
        User u = userService.updateUser(user);
        return u;
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Integer id) {
        userService.deleteUser(id);
        return "delete success";
    }

    @GetMapping("/user/uname/{uname}")
    public User getUserByUname(@PathVariable("uname") String uname) {
        User user = userService.getUserByUname(uname);
        return user;
    }
}
