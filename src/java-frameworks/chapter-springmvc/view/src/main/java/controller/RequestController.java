/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("testView")
    public String testView() {
        return "view";
    }


}
