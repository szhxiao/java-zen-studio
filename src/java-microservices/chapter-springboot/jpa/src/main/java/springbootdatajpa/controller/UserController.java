/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootdatajpa.pojo.User;
import springbootdatajpa.repository.UserRepository;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @GetMapping("/user")
    public void insertUser(User user) {
        userRepository.save(user);
    }
}
