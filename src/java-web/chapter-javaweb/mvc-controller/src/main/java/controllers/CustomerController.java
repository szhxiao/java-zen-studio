/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controllers;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import entry.Customer;
import util.JDBCUtils;
import util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class CustomerController extends ViewBaseServlet {

    private CustomerDAO customerDAO;
    private Connection connection;

    public CustomerController() {
        customerDAO = new CustomerDAOImpl();

        try {
            connection = JDBCUtils.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private String index(String operate, String keyword,
                         Integer pageNo, HttpServletRequest req) {

        HttpSession session = req.getSession();

        if (pageNo == null) {
            pageNo = 1;
        }

        if (StringUtils.isNotEmpty(operate) && "search".equals(operate)) {
            //点击表单查询发送的请求
            pageNo = 1;
            if (StringUtils.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            // keyword应从session作用域获取
            // 实现分页查询
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);

        List<Customer> customerList = customerDAO.getAll(
                connection, keyword, pageNo);
        session.setAttribute("customerList", customerList);

        // 记录总条数
        int customerCount = customerDAO.getCustomerCount(
                connection, keyword);
        // 页数
        int pageCount = (customerCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount);

        return "index";
    }

//    private String search(String operate, String keyword,
//                          Integer pageNo, HttpServletRequest req) {
//
//        HttpSession session = req.getSession();
//
//        System.out.println("index: " + operate);
//        System.out.println("index: " + keyword);
//
//        if (pageNo == null) {
//            pageNo = 1;
//        }
//
//        if (StringUtils.isNotEmpty(operate) && "search".equals(operate)) {
//            //点击表单查询发送的请求
//            pageNo = 1;
//            if (StringUtils.isEmpty(keyword)) {
//                keyword = "";
//            }
//            session.setAttribute("keyword", keyword);
//        } else {
//            // keyword应从session作用域获取
//            // 实现分页查询
//            Object keywordObj = session.getAttribute("keyword");
//            if (keywordObj != null) {
//                keyword = (String) keywordObj;
//            } else {
//                keyword = "";
//            }
//        }
//
//        session.setAttribute("pageNo", pageNo);
//
//        List<Customer> customerList = customerDAO.getAll(
//                connection, keyword, pageNo);
//        session.setAttribute("customerList", customerList);
//
//        // 记录总条数
//        int customerCount = customerDAO.getCustomerCount(
//                connection, keyword);
//        // 页数
//        int pageCount = (customerCount + 5 - 1) / 5;
//        session.setAttribute("pageCount", pageCount);
//
//        return "index";
//    }

    private String add(Integer id, String name, String email,
                       String birth) throws ParseException {

        Date birthday = StringUtils.stringToDate(birth);
        Customer customer = new Customer(id, name, email, birthday);

        customerDAO.insert(connection, customer);

        return "redirect:customer.do";
    }

    private String delete(Integer id) {
        if (id != null) {
            customerDAO.deleteById(connection, id);
            return "redirect:customer.do";
        }
        return "error";
    }

    private String edit(Integer id, HttpServletRequest req) {
        if (id != null) {
            Customer customer = customerDAO.getCustomerByID(connection, id);
            req.setAttribute("customer", customer);
            return "edit";
        }
        return "error";
    }

    private String update(Integer id, String name, String email,
                          String birth) throws ParseException {

        Date birthday = StringUtils.stringToDate(birth);
        Customer customer = new Customer(id, name, email, birthday);

        customerDAO.update(connection, customer);
        return "redirect:customer.do";
    }
}
