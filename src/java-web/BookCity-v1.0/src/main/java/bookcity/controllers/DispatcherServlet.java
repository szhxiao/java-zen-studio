/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package bookcity.controllers;


import exception.DispatcherServletException;
import bookcity.ioc.BeanFactory;
import util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
//    private Map<String, Object> beanMap = new HashMap<>();
    private BeanFactory beanFactory;

    @Override
    public void init() throws ServletException {
        super.init();
//        beanFactory = new ClassPathXMLApplicationContext();

        // 优化为从application作用域获取beanFactory
        ServletContext application = getServletContext();
        Object beanFactoryObj = application.getAttribute("beanFactory");
        if (beanFactoryObj != null) {
            beanFactory = (BeanFactory) beanFactoryObj;
        } else {
            throw new RuntimeException("Exception：IOC容器获取失败！");
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        // 由过滤器代替
//        req.setCharacterEncoding("UTF-8");

        // get servlet path,
        // 1. customer.do -> customer; customer -> CustomerController
        String servletPath = req.getServletPath();
        servletPath = servletPath.substring(1);
        int lastDotIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastDotIndex);

        Object controllerBeanObj = beanFactory.getBean(servletPath);

        String operate = req.getParameter("operate");

//        System.out.println("Got from *.html: " + operate);

        if (StringUtils.isEmpty(operate)) {
            operate = "index";
        }

        if ("search".equals(operate)) {
            operate = "index";
        }

        try {
            Method[] methods =
                    controllerBeanObj.getClass().getDeclaredMethods();

            for (Method method : methods) {
                if (operate.equals(method.getName())) {
                    // 1. 统一获取请求参数
                    // 1.1 获取当前方法的参数，返回参数数组
                    Parameter[] parameters = method.getParameters();
                    // 1.2 parameterValues 用来承参数的值
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++) {
                        String paramName = parameters[i].getName();
//                        System.out.println(paramName);


                        if ("req".equals(paramName)) {
                            parameterValues[i] = req;
                        } else if ("resp".equals(paramName)) {
                            parameterValues[i] = resp;
                        } else if ("session".equals(paramName)) {
                            parameterValues[i] = req.getSession();
                        } else {
                            String paramValue = req.getParameter(paramName);
                            String typeName = parameters[i].getType().getName();

                            Object paramObj = paramValue;

                            if (paramObj != null) {
                                if ("java.lang.Integer".equals(typeName)) {
                                    paramObj = Integer.parseInt(paramValue);
                                }
                            }

                            parameterValues[i] = paramObj;
                        }

                    }

                    // 2. controller组件中的方法调用
                    method.setAccessible(true);

                    Object returnObj = method.invoke(controllerBeanObj,
                            parameterValues);

                    // 3. 视图处理
                    String methodReutnStr = (String) returnObj;
                    if (methodReutnStr.startsWith("redirect:")) {
                        String redirectStr =
                                methodReutnStr.substring("redirect:".length());
                        resp.sendRedirect(redirectStr);
                    } else if (methodReutnStr.startsWith("json:")) {
                        String jsonStr =
                                methodReutnStr.substring("json:".length());
                        PrintWriter out = resp.getWriter();
                        out.print(jsonStr);
                        out.flush();
                    } else {
                        super.processTemplate(methodReutnStr, req, resp);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DispatcherServletException("Exception: " +
                    "DispatcherServlet");
        }
    }
}
