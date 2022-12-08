/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    // @ResponseBody
    @RequestMapping(value = "/")
    public String index(ModelMap model) {
        model.addAttribute("message", "Spring MVC Hello World");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
