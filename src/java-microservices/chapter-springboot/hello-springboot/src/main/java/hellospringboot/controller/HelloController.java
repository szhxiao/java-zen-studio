/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }
}
