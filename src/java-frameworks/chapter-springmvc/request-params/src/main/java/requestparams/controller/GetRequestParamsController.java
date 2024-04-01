/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package requestparams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("springmvc")
public class GetRequestParamsController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(
            value = {"/param"}
    )
    public String getParams() {
        return "param";
    }


}
