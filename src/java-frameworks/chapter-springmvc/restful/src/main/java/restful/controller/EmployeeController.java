/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用RESTful模拟用户资源的增删改查
 */
@Controller
public class EmployeeController {
    /**
     * users GET 查询所有用户信息
     */
    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String getAllEmployees() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    /**
     * user GET 根据Id查询用户信息
     *
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable Integer id) {
        System.out.println("根据id查询用户信息");
        return "success";
    }

    /**
     * user POST    添加用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public String saveEmployee(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

    @RequestMapping(value = "employee", method = RequestMethod.PUT)
    public String updateEmployee(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

}
