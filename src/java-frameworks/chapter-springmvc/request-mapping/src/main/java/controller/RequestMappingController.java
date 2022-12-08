/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(
            value = {"/success", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @RequestMapping(
            value = {"/testParams"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username", "password!=123456"}
    )
    public String testParams() {
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id") Integer id,
                           @PathVariable("username") String username) {
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        return "success";
    }
}
