/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController
public class KungfuController {
    private final String PREFIX = "pages/";

    @GetMapping("/")
    public String index() {
        return "welcome";
    }


    @GetMapping("/userlogin")
    public String toLoginPage() {
        System.out.println("arrived login page");
        return PREFIX + "login";
    }

    /*
    @PostMapping("/userlogin")
    public String login() {
        return "welcome";
    }
     */

    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path") String path) {
        return PREFIX + "level1/" + path;
    }

    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path") String path) {
        return PREFIX + "level2/" + path;
    }

    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path") String path) {
        return PREFIX + "level3/" + path;
    }


}
