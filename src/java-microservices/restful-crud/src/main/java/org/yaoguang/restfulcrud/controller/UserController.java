/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.yaoguang.restfulcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yaoguang.restfulcrud.pojo.User;
import org.yaoguang.restfulcrud.service.UserService;

import java.util.List;

@Controller
// @RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "user-list";
    }

    @GetMapping("/user")
    public String toSavePage() {
        return "user-save";
    }

    @PostMapping("/user")
    public String saveUser(User user) {
        // redirect表示重定向到一个地址
        // forward表示转发到一个地址
        // logger.info(user.toString());
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PutMapping("/user")
    public String updateUser(User user) {
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String removeUser(@PathVariable("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}
