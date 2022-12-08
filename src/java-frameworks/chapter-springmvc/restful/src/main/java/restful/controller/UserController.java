/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import restful.pojo.User;
import restful.service.UserService;

import java.util.List;

/**
 * 使用RESTful模拟用户资源的增删改查
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * users GET 查询所有用户信息
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        System.out.println("查询所有用户信息");
        List<User> userList = userService.getAllUsers();
        // System.out.println(userList);
        model.addAttribute("userList", userList);
        return "user-list";
    }

    /**
     * user GET 根据Id查询用户信息
     *
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    /**
     * user POST    添加用户
     *
     * @param user 用户
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * user PUT 修改用户信息
     *
     * @param user 用户
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    /**
     * user DELETE  删除用户信息
     *
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable("id") Integer id) {
        System.out.println("删除用户信息");
        userService.removeUser(id);
        return "redirect:/users";
    }

}
