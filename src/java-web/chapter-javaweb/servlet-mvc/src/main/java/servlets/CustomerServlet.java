/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package servlets;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import entry.Customer;
import util.JDBCUtils;
import util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;


@WebServlet("/customer.do")
public class CustomerServlet extends ViewBaseServlet {
    private CustomerDAO customerDAO = null;
    private Connection connection = null;

    public CustomerServlet() {
        customerDAO = new CustomerDAOImpl();

        try {
            connection = JDBCUtils.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");

        String operate = req.getParameter("operate");
        if (StringUtils.isEmpty(operate)) {
            operate = "index";
        }

        // 获取当前类中所有方法
//       Method[] methods = this.getClass().getDeclaredMethods();
//       for (Method m : methods) {
//           // 获取方法名称
//           String methodName = m.getName();
//           if (operate.equals(methodName)) {
//               try {
//                   // 找到和operate同名的方法，通过反射技术调用
//                   m.invoke(this, req, resp);
//                   return;
//               } catch (IllegalAccessException e) {
//                   e.printStackTrace();
//               } catch (InvocationTargetException e) {
//                   e.printStackTrace();
//               }
//           }
//           throw new RuntimeException("异常：operate值非法");
//       }

       switch (operate) {
           case "index":
               index(req, resp);
               break;
           case "add":
               try {
                   add(req, resp);
               } catch (ParseException e) {
                   e.printStackTrace();
               }
               break;
           case "delete":
               delete(req, resp);
               break;
           case "edit":
               edit(req, resp);
               break;
           case "update":
               try {
                   update(req, resp);
               } catch (ParseException e) {
                   e.printStackTrace();
               }
               break;
           default:
               throw new RuntimeException("异常：operate值非法");
       }
    }

    private void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        // 设置当前页，默认值为1
        Integer pageNo = 1;

        String operator = req.getParameter("operator");
        String keyword = null;

        if (StringUtils.isNotEmpty(operator) && "search".equals(operator)) {
            //点击表单查询发送的请求
            // pageNo还原为1，keyword从请求参数中获取
            pageNo = 1;
            keyword = req.getParameter("keyword");
            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            // 不是点击查询表单发送的请求（如上一页、下一页、首页、尾页）
            // keyword应从session作用域获取
            // 实现分页查询
            String pageNoStr = req.getParameter("pageNo");
            if (StringUtils.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);

//        List<Customer> customerList = null;
        List<Customer> customerList = customerDAO.getAll(
                connection, keyword, pageNo);
        session.setAttribute("customerList", customerList);

        // 记录总条数
        int customerCount = customerDAO.getCustomerCount(
                connection, keyword);
        // 页数
        int pageCount = (customerCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount);

        super.processTemplate("list", req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ParseException {
        // 设置编码，防止乱码
        req.setCharacterEncoding("UTF-8");

        // get id
        String idStr = req.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        // get name
        String name = req.getParameter("name");
        // get email
        String email = req.getParameter("email");
        // get birth
        String birthStr = req.getParameter("birth");

        Date birth = StringUtils.stringToDate(birthStr);
        Customer customer = new Customer(id, name, email, birth);

        customerDAO.insert(connection, customer);

        resp.sendRedirect("customer.do");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (StringUtils.isNotEmpty(idStr)) {
            int id = Integer.parseInt(idStr);
            customerDAO.deleteById(connection, id);
        }

        resp.sendRedirect("customer.do");
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idStr = req.getParameter("id");
//        System.out.println("Got cidStr: " + idStr);
        if (StringUtils.isNotEmpty(idStr)) {
            int id = Integer.parseInt(idStr);
            Customer customer = customerDAO.getCustomerByID(
                    connection, id);
//                System.out.println(customer);
            req.setAttribute("customer", customer);
            super.processTemplate("edit", req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, ParseException {
        // 1. 设置编码
        req.setCharacterEncoding("UTF-8");
        // 2. 获取参数
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthStr = req.getParameter("birth");

        Date birth = StringUtils.stringToDate(birthStr);
        Customer customer = new Customer(id, name, email, birth);
        // 3. 执行更新
        customerDAO.update(connection, customer);

        // 4. 资源跳转

//        super.processTemplate("list", req, resp);
        // 进行重定向，重新给ListServlet发请求
        resp.sendRedirect("customer.do");
    }
}
