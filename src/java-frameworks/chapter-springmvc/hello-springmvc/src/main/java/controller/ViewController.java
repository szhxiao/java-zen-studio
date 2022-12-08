/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
public class ViewController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        // 业务代码
        String message = "Hello SpringMVC";
        mv.addObject("msg", message);

        // 视图解析
        mv.setViewName("index");

        return mv;
    }
}
*/