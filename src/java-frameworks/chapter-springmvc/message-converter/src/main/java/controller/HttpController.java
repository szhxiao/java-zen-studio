/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

import java.io.IOException;

@Controller
public class HttpController {

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody: " + requestBody);
        return "success";
    }

    @RequestMapping("testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("请求头: " + requestEntity.getHeaders());
        System.out.println("请求体: " + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello response");
    }

    @RequestMapping("testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    @RequestMapping("testResponseObject")
    @ResponseBody
    public User testResponseObject() {
        return new User(1, "admin",
                "admin", "local@123.com");
    }

    @RequestMapping("testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "hello, axios";
    }
}
