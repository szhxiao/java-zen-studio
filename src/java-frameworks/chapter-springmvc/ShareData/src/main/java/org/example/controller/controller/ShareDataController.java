/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ShareDataController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    // 使用ServletAPI向request域对象共享数据
    @RequestMapping(
            value = {"/testRequestByServlet"}
    )
    public String testRequestByServlet(HttpServletRequest request) {
        request.setAttribute("requestScope", "Share data by ServletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        // 处理模型数据，即向请求域共享数据
        mav.addObject("requestScope", "Share data by ModelAndView");
        // 设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("requestScope", "Share data by Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("requestScope", "Share data by Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("requestScope", "Share data by ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("sessionScope", "Share data by Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("applicationScope", "Share data by " +
                "Application");
        return "success";
    }
}
