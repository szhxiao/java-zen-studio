/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package controllers;

import entry.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;
import util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public class CustomerController extends ViewBaseServlet {
//    private CustomerService customerService = new CustomerServiceImpl();

    // 解耦
    private CustomerService customerService = null;

    private String add(Integer id, String name, String email,
                       String birth) throws ParseException {

        Date birthday = StringUtils.stringToDate(birth);
        Customer customer = new Customer(id, name, email, birthday);

        customerService.addCustomer(customer);

        return "redirect:customer.do";
    }

    private String delete(Integer id) {
        if (id != null) {
            customerService.deleteCustomer(id);
            return "redirect:customer.do";
        }
        return "error";
    }

    private String edit(Integer id, HttpServletRequest req) {
        if (id != null) {
            Customer customer = customerService.getCustomerById(id);
            req.setAttribute("customer", customer);
            return "edit";
        }
        return "error";
    }

    private String update(Integer id, String name, String email,
                          String birth) throws ParseException {

        Date birthday = StringUtils.stringToDate(birth);
        Customer customer = new Customer(id, name, email, birthday);
        customerService.updateCustomer(customer);

        return "redirect:customer.do";
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

        List<Customer> customerList = customerService.getCustomerList(keyword
                , pageNo);
        session.setAttribute("customerList", customerList);

        // 页数
        int pageCount = customerService.getPageCount(keyword);
        session.setAttribute("pageCount", pageCount);

        return "index";
    }

}
