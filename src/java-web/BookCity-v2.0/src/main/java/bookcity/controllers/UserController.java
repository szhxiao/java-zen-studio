/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.controllers;


import bookcity.pojo.Cart;
import bookcity.pojo.User;
import bookcity.services.CartItemService;
import bookcity.services.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserController {
    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String password, HttpSession session) {
        User user = userService.login(uname, password);
//        System.out.println(user);
        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser", user);
            return "redirect:book.do";
        }
        return "user/login";
    }

    public String regist(String uname, String password, String email,
                         String verifyCode, HttpSession session,
                         HttpServletResponse resp) throws IOException {
        System.out.println("begin regist...");
        System.out.println("uname: " + uname);
        Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (kaptchaCodeObj == null || !verifyCode.equals(kaptchaCodeObj)) {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script language='javascript'>alert('验证码不正确');window" +
                    ".location.href='page.do?operate=page&page=user/regist'" +
                    "</script>");
//            return "user/regist";
            return "";
        } else {
            if (verifyCode.equals(kaptchaCodeObj)) {
                userService.regist(new User(uname, password, email, 0));
                return "user/login";
            }
        }
        return "user/login";
    }

    public String checkUname(String uname) {
        User user = userService.getUser(uname);
        if (user != null) {
            // 用户名被占用，不可注册
            return "json:{'uname':'1'}";
        } else {
            return "json:{'uname':'0'}";
        }
    }

}
