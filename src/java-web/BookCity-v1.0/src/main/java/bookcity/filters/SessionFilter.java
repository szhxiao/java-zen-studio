/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

//@WebFilter(urlPatterns = {"*.do", "*.html"},
//    initParams = {
//        @WebInitParam(name="hello",
//                value = "/BookCity/page.do?operate=page&page=user/login," +
//                        "/BookCity/user.do?null")
//    })
public class SessionFilter implements Filter {
    private String encoding = "UTF-8";
    private List<String> helloList = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        String hello = filterConfig.getInitParameter("hello");
        String[] strArr = hello.split(",");
        helloList = Arrays.asList(strArr);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        System.out.println("req.getQueryString() = " + req.getQueryString());

        String uri = req.getRequestURI();
        String queryStr = req.getQueryString();
        String str = uri + "?" + queryStr;
        if (helloList.contains(str)) {
            chain.doFilter(req, resp);
            return;
        } else {
            HttpSession session = req.getSession();
            Object currUserObj = session.getAttribute("currUser");
            if (currUserObj == null) {
                resp.sendRedirect("page.do?operate=page&page=user/login");
            } else {
                chain.doFilter(req, resp);
            }
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
