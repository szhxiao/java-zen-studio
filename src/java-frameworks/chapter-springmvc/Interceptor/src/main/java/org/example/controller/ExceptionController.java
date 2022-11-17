/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ExceptionController {
    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1/0);
        return "success";
    }

    @ExceptionHandler(value = {ArithmeticException.class,
            NullPointerException.class})
    public String textExceptionAnnotation(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }

}
