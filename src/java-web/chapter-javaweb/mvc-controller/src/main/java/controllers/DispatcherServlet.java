/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controllers;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("*.do")
public class DispatcherServlet extends ViewBaseServlet {
    private Map<String, Object> beanMap = new HashMap<>();


    @Override
    public void init() throws ServletException {
        super.init();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(
                    "applicationContext.xml");
            // 1. 创建DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // 2. 创建DocumentBuilder对象
            DocumentBuilder builder = dbf.newDocumentBuilder();
            // 3. 创建Document对象
            Document document = builder.parse(is);
            // 4. 获取所有bean节点
            NodeList nodes = document.getElementsByTagName("bean");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element bean = (Element) node;
                    String beanId = bean.getAttribute("id");
                    String className = bean.getAttribute("class");
                    Class controllerBeanClass = Class.forName(className);
                    Object beanObj = controllerBeanClass.newInstance();

                    beanMap.put(beanId, beanObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");

        // get servlet path,
        // 1. customer.do -> customer; customer -> CustomerController
        String servletPath = req.getServletPath();
        servletPath = servletPath.substring(1);
        int lastDotIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(0, lastDotIndex);

        Object controllerBeanObj = beanMap.get(servletPath);

        String operate = req.getParameter("operate");

//        System.out.println("Got from *.html: " + operate);

        if (StringUtils.isEmpty(operate)) {
            operate = "index";
        }

        if ("search".equals(operate)) {
            operate = "index";
        }

        try {
//            Method method = controllerBeanObj.getClass().getDeclaredMethod(
//                    operate, HttpServletRequest.class);
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
                    } else {
                        super.processTemplate(methodReutnStr, req, resp);
                    }
                }
//                else {
//                    throw new RuntimeException("异常：operate值非法");
//                }

            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
