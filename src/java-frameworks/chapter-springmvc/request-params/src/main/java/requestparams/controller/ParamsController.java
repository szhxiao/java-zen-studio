/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package requestparams.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import requestparams.pojo.User;

import java.util.Arrays;

@Controller
public class ParamsController {
    @RequestMapping("/testServletAPI")
    // 参数request表示当前请求
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

    @RequestMapping("/testGetParam")
    public String testGetParam(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }

    @RequestMapping("/testParams")
    // 请求参数出现多个同名请求参数，可在参数中使用字符串类型或字符串数组接收
    // public String testParams(String username, String password,
    //                          String interests) {
    public String testParams(
            @RequestParam("user_name") String username,
            String password, String[] interests,
            @RequestHeader("Host") String host) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        // System.out.println("interests: " + interests);
        System.out.println("interests: " + Arrays.toString(interests));
        System.out.println("host: " + host);
        return "success";
    }

    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return "success";
    }

}
