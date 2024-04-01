/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.lastName}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello " + name;
    }
}
