/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
