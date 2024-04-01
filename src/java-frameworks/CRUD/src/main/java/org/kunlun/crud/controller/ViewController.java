/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.kunlun.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String index() {
        return "helloworld";
    }

    @RequestMapping("list_employees_ajax")
    public String listEmployees() {
        return "emp_list_ajax";
    }
}
