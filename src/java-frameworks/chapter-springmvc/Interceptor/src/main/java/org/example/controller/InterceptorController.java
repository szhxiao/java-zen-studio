/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {
    @RequestMapping("testInterceptor")
    public String testInterceptor() {
        return "success";
    }

}
